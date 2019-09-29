package ayds.tweetsearcher.presentation.model;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;

import ayds.tweetsearcher.domain.FindTweets;

public interface SearchTweetsInteractor {
    void searchTweets(String username);
    void setFindTweetsUseCase(FindTweets findTweets);
    void onTweetsFound(List<Tweet> tweets);
    void onError();
}

