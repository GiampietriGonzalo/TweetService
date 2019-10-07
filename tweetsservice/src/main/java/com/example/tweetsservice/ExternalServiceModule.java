package com.example.tweetsservice;

public class ExternalServiceModule {

    private static ExternalServiceModule instance;

    private ExternalServiceModule() {}

    public static ExternalServiceModule getInstance() {
        if (instance == null) {
            instance = new ExternalServiceModule();
        }
        return instance;
    }

    public TwitterService getTwitterlService() {
        return new TwitterServiceImp();
    }
}

