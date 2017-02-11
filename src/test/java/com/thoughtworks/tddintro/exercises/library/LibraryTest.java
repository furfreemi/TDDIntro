package com.thoughtworks.tddintro.exercises.library;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private List<String> books;
    private PrintStream printStream;
    private Library library;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = new Library(books, printStream, bufferedReader);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by the printStream
        verify(printStream).println(Mockito.contains(title));
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        // don't add any books to the library list

        // call listBooks
        library.listBooks();

        // verify that empty string was printed out
        verify(printStream).println("");
    }

    // This is redundant based on the next test but it was one given to us so I kept it
    // Also wanted to try out calling verify multiple times across a single object/method call
    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        // add two book titles
        String title1 = "Book Title1";
        books.add(title1);

        String title2 = "Book Title2";
        books.add(title2);


        // print titles
        library.listBooks();

        // verify that both titles were printed by stream
        verify(printStream).println(Mockito.contains(title1));
        verify(printStream).println(Mockito.contains(title2));
    }


    @Test
    public void shouldPrintNewLineBetweenMultipleBookTitles() throws IOException {
        // add two book titles
        String title1 = "Title1";
        books.add(title1);

        String title2 = "Title2";
        books.add(title2);


        // print titles
        library.listBooks();

        // verify that both titles were printed by stream
        verify(printStream).println(Mockito.contains(title1 + '\n' + title2));
    }



    @Test
    public void shouldAddBookToCollectionWhenEnteredByUser() throws IOException {
        when(bufferedReader.readLine()).thenReturn("The Hobbit");

        library.enterBook();

        assertThat(books, hasItems("The Hobbit"));
    }

    @Test
    public void shouldDeleteBookFromCollectionWhenRemovedByUser() throws IOException {
        // Add when/thenReturn here: we want to test delete The Two Towers
        String title = "The Two Towers";
        when(bufferedReader.readLine()).thenReturn(title);

        books.add(title);
        library.removeBook();

        assertThat(books, not(hasItems(title)));
    }
}
