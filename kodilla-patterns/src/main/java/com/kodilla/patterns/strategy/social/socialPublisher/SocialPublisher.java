package com.kodilla.patterns.strategy.social.socialPublisher;

public sealed interface SocialPublisher permits FacebookPublisher, TwitterPublisher, SnapchatPublisher  {
    public String share();
}
