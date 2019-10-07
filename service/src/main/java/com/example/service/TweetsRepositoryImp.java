package com.example.service;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;

class TweetsRepositoryImp implements TweetsRepository {

    private final TwitterService externalService;

    TweetsRepositoryImp(TwitterService externalService) {
        this.externalService = externalService;
    }

    @Override
    public void findTweets(String query, SearchListener listener, SearchErrorListener errorListener) {
        List<Tweet> tweets = externalService.findTweets(query);
        if (tweets == null || tweets.isEmpty()) {
            errorListener.onError();
        } else {
            listener.onFound(externalService.findTweets(query));
        }
    }

}
