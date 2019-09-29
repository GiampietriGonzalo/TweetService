package ayds.tweetsearcher.presentation.view;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import ayds.tweetsearcher.presentation.presenter.ShowTweetsPresenter;

public interface ShowTweetsView {
    void setPresenter(ShowTweetsPresenter presenter);
    void showTweets(List<Tweet> tweets);
    void showError();
}
