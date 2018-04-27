package org.cas.formulus.data;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.datatypes.FetchSet;
import com.basho.riak.client.api.commands.datatypes.SetUpdate;
import com.basho.riak.client.api.commands.datatypes.UpdateSet;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.api.commands.kv.UpdateValue;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.util.BinaryValue;
import org.cas.formulus.entity.Formulation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Repository
public class FormulationRepo {
    private RiakClient m_client;
    private Namespace m_bucket;
    private Location m_idLocations;

    public FormulationRepo() {
        m_bucket = new Namespace("formulations");
        m_idLocations = new Location(new Namespace("set", "idset"), "locid");
    }

    private void connect() {
        RiakNode node = new RiakNode.Builder().withRemoteAddress("127.0.0.1").build();
        RiakCluster cluster = RiakCluster.builder(node).build();
        cluster.start();
        m_client = new RiakClient(cluster);
    }

    private Formulation internalGetById(String id) {
        Location location = new Location(m_bucket, id);
        FetchValue fv = new FetchValue.Builder(location).build();
        try {
            FetchValue.Response response = m_client.execute(fv);
            return response.getValue(Formulation.class);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Formulation getById(String id) {
        connect();
        return internalGetById(id);
    }

    public Collection<Formulation> getAll() {
        connect();
        ArrayList<Formulation> result = new ArrayList<>();
        getAllKeys().forEach(s -> result.add(internalGetById(s)));
        return result;
    }

    private Collection<String> getAllKeys() {
        FetchSet fs = new FetchSet.Builder(m_idLocations).build();
        ArrayList<String> result = new ArrayList<>();

        try {
            FetchSet.Response res = m_client.execute(fs);
            res.getDatatype().view().forEach(
                    (BinaryValue val) -> result.add(new String(val.getValue())));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Formulation insert(Formulation formulation) {
        connect();

        String key = UUID.randomUUID().toString();
        formulation.setId(key);

        // Add new id of formulation to the set of ids
        SetUpdate su = new SetUpdate();
        su.add(key);
        UpdateSet us = new UpdateSet.Builder(m_idLocations, su).build();

        // Store the formulation
        Location location = new Location(m_bucket, key);
        StoreValue sv = new StoreValue.Builder(formulation).withLocation(location).build();
        try {
            m_client.execute(sv);
            m_client.execute(us);
            return formulation;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Formulation update(Formulation formulation) {
        connect();
        Location location = new Location(m_bucket, formulation.getId());
        FormulationUpdate updatedFormulation = new FormulationUpdate(formulation);
        UpdateValue uv = new UpdateValue.Builder(location).withUpdate(updatedFormulation).build();
        try {
            UpdateValue.Response response = m_client.execute(uv);
            return response.getValue(Formulation.class);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String id) {
        connect();
        Location location = new Location(m_bucket, id);
        DeleteValue dv = new DeleteValue.Builder(location).build();
        try {
            m_client.execute(dv);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
