package app;

/**
 * Created by Krzysztof Podlaski on 04.03.2019.
 */
public interface DataBase {

    Author getAuthorById(int id);
    List<Author> getAuthorByName(String name);
    Book getBookById(int id);
    List<Book> getBookByTitle(String title);
    List<Book> getBookByAuthor(Author a);
    int addNewAuthor(Author a);
    int addNewBook(Book b);
}
