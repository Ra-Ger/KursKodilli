package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {
    @Test
    void testGetBooks()
    {
        Library library = new Library("Babilon");
        Book book1 = new Book("Boring Book","John Borington", LocalDate.of(1925 ,7,18));
        Book book2 = new Book("101 reasons to do nothing","Aloysy Nevermind", LocalDate.of(2004 ,1,20));
        Book book3 = new Book("Wy are you like that?","Simon Kaggwa", LocalDate.of(2012 ,12,18));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library libraryShallowCopy = null;
        Library libraryDeepCopy = null;
        try {
           libraryShallowCopy = library.shallowCopy();
           libraryDeepCopy = library.deepCopy();

        }
        catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        assertEquals(3, library.getBooks().size());
        assertNotEquals(true, library.getBooks() == libraryDeepCopy.getBooks());
        libraryShallowCopy.getBooks().remove(book3);
        assertEquals(2, libraryShallowCopy.getBooks().size());
        libraryDeepCopy.getBooks().clear();
        assertEquals(2, library.getBooks().size());
    }
}
