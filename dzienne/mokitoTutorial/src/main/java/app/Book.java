package app;

import java.util.Comparator;

/**
 * Created by Krzysztof Podlaski on 04.03.2019.
 */
public class Book {
    private int id;
    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.id = -1;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public static Comparator<Book> getTitleComparator() {
        return new Comparator<Book>(){
            public int compare(Book a, Book b){
                return a.getTitle().compareToIgnoreCase(b.getTitle());
            }
        };
    }
}
