package com.kodilla.testing.collection;

import com.kodilla.testing.collection.*;
import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;
import java.util.*;

public class CollectionTestSuite
{
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("checking the operation with an empty list")
    @Test
    void testOddNumbersExterminatorEmptyList ()
    {
        //Given
        OddNumbersExterminator ONE = new OddNumbersExterminator();
        //When
        List<Integer> result = ONE.exterminate(new ArrayList<Integer>());
        //Then
        Assertions.assertEquals(new ArrayList<Integer>(), result);
    }

    @DisplayName("checking the operation with an normal list")
    @Test
    void testOddNumbersExterminatorNormalList()
    {
        //Given
        OddNumbersExterminator ONE = new OddNumbersExterminator();
        List<Integer> numberList = List.of(1,2,3,4,5,6,7,8,9);
        //When
        List<Integer> result = ONE.exterminate(numberList);
        //Then
        Assertions.assertEquals(List.of(2,4,6,8), result);
    }
}
