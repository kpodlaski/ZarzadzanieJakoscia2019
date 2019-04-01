package app;

import java.util.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

/**
 * Created by Krzysztof Podlaski on 04.03.2019.
 */

public class DataOperationsTest {

    DataOperations dataOp;
    @Mock
    DataBase testDB;
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void preareTest(){
        dataOp = new DataOperations(testDB);
    }

    @Test
    public void showListOfBooks(){
        //Definicja bazy dla przypadku testowego
        List<Book> bookList = new ArrayList<Book>();
        Author a = new Author("Adam Mickiewicz");
        bookList.add(new Book("Pan Tadeusz",a));
        bookList.add(new Book("Dziady",a));
        when(testDB.getAllBooks()).thenReturn(new ArrayList(bookList));
        //Wykonaj operacje do testowania
        List<Book> books = dataOp.showListOfBooks();
        //Sprawdź poprawność działania (wynik)
        assertEquals(bookList.get(1),books.get(0));
        assertEquals(bookList.get(0),books.get(1));
    }

    @Test
    public void testowanieNaszejBazyCD(){
        Author a = new Author("Adam Mickiewicz");
        a.setId(12);
        when(testDB.getAuthorById(12)).thenReturn(a);
        when(testDB.getAuthorById(122)).thenReturn(null);

        Author x= testDB.getAuthorById(12);
        assertEquals(a,x);
        x= testDB.getAuthorById(122);
        assertNull(x);
    }
}
