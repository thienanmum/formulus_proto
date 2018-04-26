package riakdemo.demo;

import com.basho.riak.client.api.commands.kv.UpdateValue;

//This will allow us to update the book object handling the
// entire fetch/modify/update cycle.
public class BookUpdate extends UpdateValue.Update<Book> {
	
    private final Book update;
    public BookUpdate(Book update){
        this.update = update;
    }

    @Override
    public Book apply(Book t) {
        if(t == null) {
            t = new Book();
        }

        t.author = update.author;
        t.body = update.body;
        t.copiesOwned = update.copiesOwned;
        t.isbn = update.isbn;
        t.title = update.title;

        return t;
    }
}
