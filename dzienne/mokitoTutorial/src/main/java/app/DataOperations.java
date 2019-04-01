package app;
import java.util.*;

/**
 * Created by Krzysztof Podlaski on 04.03.2019.
 */
public class DataOperations {
    DataBase db;

    public DataOperations(DataBase db) {
        this.db = db;
    }

    public List<Book> showListOfBooks(){
        List<Book> books = db.getAllBooks();
        Collections.sort(books,Book.getTitleComparator());
        /*for(Book b : books){
            System.out.println(b);
        }
        */
        return books;
    }
}
