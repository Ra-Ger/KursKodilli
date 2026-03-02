package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private Logger logger = Logger.INSTANCE;

    @Test
    void testGetLog() {
        String log = "Witam";
        logger.log(log);

        assertEquals(log,logger.getLastLog());
    }
}
