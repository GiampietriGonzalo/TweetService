package com.example.tweetsservice;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;

public interface TwitterService {
    List<Tweet> findTweets(String query);
}
