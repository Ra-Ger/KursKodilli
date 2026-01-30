package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage()
    {
        int[] myArray =  {1,2,3,4,5,6};
        int[] secounArray = new int[0];
        int[] thirdArray = { -10,20};

        assertEquals(3.5, ArrayOperations.getAverage(myArray),0.001);
        assertEquals(0.0, ArrayOperations.getAverage(secounArray),0.001);
        assertEquals(5.0, ArrayOperations.getAverage(thirdArray),0.001);
    }
}
