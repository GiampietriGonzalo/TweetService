package ayds.tweetsearcher.presentation.model;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import ayds.tweetsearcher.domain.FindTweets;
import ayds.tweetsearcher.presentation.presenter.ShowTweetsPresenter;

class SearchTweetsInteractorImp implements SearchTweetsInteractor {

    private FindTweets findTweets;
    private final ShowTweetsPresenter presenter;

    SearchTweetsInteractorImp(ShowTweetsPresenter presenter) {
        this.presenter = presenter;
    }

    public void searchTweets(String username) {
        findTweets.execute(username, this::onTweetsFound, this::onError);
    }

    public void onTweetsFound(List<Tweet> tweets) {
        presenter.showTweets(tweets);
    }

    public void onError() {
        presenter.showErrorMessage();
    }

    public void setFindTweetsUseCase(FindTweets findTweets) {
        this.findTweets = findTweets;
    }

}
