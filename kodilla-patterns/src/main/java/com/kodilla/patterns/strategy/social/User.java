package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialPublisher.SocialPublisher;

public sealed abstract class User permits Millenials, YGeneration, ZGeneration{
    private final String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher)
    {
        this.socialPublisher = socialPublisher;
    }

    public String sharePost()
    {
        return socialPublisher.share();
    }
}
