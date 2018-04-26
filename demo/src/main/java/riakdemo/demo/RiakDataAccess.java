package riakdemo.demo;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.Collection;
import java.util.LinkedList;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.query.RiakObject;
import com.basho.riak.client.core.util.BinaryValue;

public class RiakDataAccess {
	private RiakCluster  m_cluster;
	
	private RiakClient connectToRiak() {
		if (m_cluster == null) {
			RiakNode.Builder builder = new RiakNode.Builder();
			builder.withMinConnections(10);
			builder.withMaxConnections(50);
	
			List<String> addresses = new LinkedList<String>();
			addresses.add("127.0.0.1");
	
			List<RiakNode> nodes = RiakNode.Builder.buildNodes(builder, addresses);
			m_cluster = new RiakCluster.Builder(nodes).build();
			m_cluster.start();
		}
		
		RiakClient client = new RiakClient(m_cluster);
		return client;
	}
	
	public void insertFormulation() {
		RiakClient client = connectToRiak();
		Namespace ns = new Namespace("default","test");
		Location loc = new Location(ns, "my_key");
		RiakObject ro = new RiakObject();
		ro.setValue(BinaryValue.create("This is my value"));
		StoreValue sv = 
		     new StoreValue.Builder(ro).withLocation(loc).build();
		try {
			StoreValue.Response response = client.execute(sv);
			System.out.println(response.toString());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Collection<Formulation> getAllFormulation() {
		RiakClient client = connectToRiak();
		Namespace ns = new Namespace("default","test");
		Location loc = new Location(ns, "my_key");
		FetchValue fv = new FetchValue.Builder(loc).build();
		try {
			FetchValue.Response response = client.execute(fv);
			response.getValues().forEach((RiakObject o) -> {
				System.out.println(new String(o.getValue().getValue()));
			});			
			
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
