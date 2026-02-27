package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialPublisher.SnapchatPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies()
    {
        User userM = new Millenials("Bob Marley");
        User userY = new YGeneration("Angelina Joli");
        User userZ = new ZGeneration("Wesoły Romek");

        assertEquals("Send Facebook spam", userM.sharePost());
        assertEquals("Send photo of cat", userY.sharePost());
        assertEquals("Send noodles", userZ.sharePost());
    }

    @Test
    void testIndividualSharingStrategy()
    {
        User userM = new Millenials("Adam Małysz");
        userM.setSocialPublisher(new SnapchatPublisher());
        assertEquals("Send noodles",userM.sharePost());
    }
}
