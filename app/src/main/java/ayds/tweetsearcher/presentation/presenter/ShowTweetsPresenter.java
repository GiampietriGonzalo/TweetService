package ayds.tweetsearcher.presentation.presenter;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import ayds.tweetsearcher.presentation.model.SearchTweetsInteractor;

public interface ShowTweetsPresenter {
    void searchTweets(String username);
    void setUseCaseInteractor(SearchTweetsInteractor useCaseInteractor);
    void showTweets(List<Tweet> tweets);
    void showErrorMessage();
}
