package com.kodilla.patterns.strategy.social.socialPublisher;

public final class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return  "Send noodles";
    }
}
