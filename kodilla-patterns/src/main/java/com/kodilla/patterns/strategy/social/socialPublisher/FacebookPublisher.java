package com.kodilla.patterns.strategy.social.socialPublisher;

public final class FacebookPublisher implements SocialPublisher{
    @Override
    public String share() {
        return "Send Facebook spam";
    }
}
