package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianAdapterTestSuite {

     @Test
    void publicationYearMedianTest()
     {
         //Given
         Set<Book> books = new HashSet<>(Arrays.asList(new Book("Antoni Ciecierewicz","Spadające samoloty",2012,"D3B1L"), new Book("Jan Jabolanek","Moja gorzelnia",1994,"HVJ410"), new Book("Drian Zandbee","Konfederazem",1999,"KVT4CZ"), new Book("Joanna Muderfokier","Motylem jestem",2021,"CVV3L"), new Book("Adelajda Wafel-Kafel","Jak to jest być gołębiem?",1987,"G3J0Z4"), new Book("Władimir Uruk-Jebiwdenko","Do dna i na dno!",1967,"5ZM4T4"), new Book("Adam Alfonsiero","Handel żywym towarem w świetle prawa rzymskiego.",1991,"KVRVV4")));
         MedianAdapter medianAdapter = new MedianAdapter();

         //When
         int median = medianAdapter.publicationYearMedian(books);

         //Then
         //             <mediana>
         //1967 1987 1991 |1994| 1999 2012 2021
         assertEquals(1994,median);
     }
}
