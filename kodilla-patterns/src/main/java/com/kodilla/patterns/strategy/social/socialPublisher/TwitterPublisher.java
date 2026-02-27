package com.kodilla.patterns.strategy.social.socialPublisher;

public final class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Send photo of cat";
    }
}
