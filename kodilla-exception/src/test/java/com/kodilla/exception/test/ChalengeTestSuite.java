package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChalengeTestSuite {
    @Test
    public void exceptionTest()
    {
        SecondChallenge secondChallenge = new SecondChallenge();

        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2,1)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99,1)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1,1)),

                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.1,1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.1,1.5001))
        );
    }
}
