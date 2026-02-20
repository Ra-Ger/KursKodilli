package com.kodilla.good.patterns.challenges.posComponents;

public class SMS implements IInformationService{
    @Override
    public void sendMessage(User user) {
        System.out.println("SMS was stended to " + user.getName());
    }
}
