package ayds.tweetsearcher.presentation.presenter;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import ayds.tweetsearcher.presentation.model.SearchTweetsInteractor;
import ayds.tweetsearcher.presentation.view.ShowTweetsView;

class ShowTweetsPresenterImp implements ShowTweetsPresenter  {

    private ShowTweetsView view;
    private SearchTweetsInteractor useCaseInteractor;

    ShowTweetsPresenterImp() {}

    void setView(ShowTweetsView view) {
        this.view = view;
    }

     public void searchTweets(String username) {
         Thread onSearch = new Thread(() -> useCaseInteractor.searchTweets( username));
         onSearch.start();
     }

    public void setUseCaseInteractor(SearchTweetsInteractor useCaseInteractor) {
        this.useCaseInteractor = useCaseInteractor;
    }

    public void showTweets(List<Tweet> tweets) {
        view.showTweets(tweets);
    }

    public void showErrorMessage() {
        view.showError();
    }
}
