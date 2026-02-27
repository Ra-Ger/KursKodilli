package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialPublisher.TwitterPublisher;

public final class YGeneration extends User {
    public YGeneration(String name) {
        super(name);
        socialPublisher = new TwitterPublisher();
    }
}
