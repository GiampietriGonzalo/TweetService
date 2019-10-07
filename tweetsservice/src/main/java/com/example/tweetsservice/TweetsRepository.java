package com.example.tweetsservice;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;

public interface TweetsRepository {

    void findTweets(String query, SearchListener listener, SearchErrorListener errorListener);

    interface SearchListener {
        void onFound(List<Tweet> tweets);
    }

    interface SearchErrorListener {
        void onError();
    }
}
