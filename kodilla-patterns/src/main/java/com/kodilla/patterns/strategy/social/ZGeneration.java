package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialPublisher.SnapchatPublisher;

public final class ZGeneration extends User {
    public ZGeneration(String name) {
        super(name);
        socialPublisher = new SnapchatPublisher();
    }
}
