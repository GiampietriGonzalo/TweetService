package ayds.tweetsearcher.presentation.presenter;

import ayds.tweetsearcher.presentation.model.SearchTweetsInteractor;
import ayds.tweetsearcher.presentation.model.ShowTweetsPresentationModule;
import ayds.tweetsearcher.presentation.view.ShowTweetsView;

public class PresenterModule {

    private static PresenterModule instance;

    private PresenterModule() {}

    public static PresenterModule getInstance() {
        if (instance == null) {
            instance = new PresenterModule();
        }

        return instance;
    }

    public ShowTweetsPresenter getPresenter(ShowTweetsView view) {
        ShowTweetsPresenterImp presenter = new ShowTweetsPresenterImp();
        SearchTweetsInteractor useCaseInteractor = ShowTweetsPresentationModule.getInstance().getUseCaseInteractor(presenter);
        presenter.setUseCaseInteractor(useCaseInteractor);
        presenter.setView(view);

        return presenter;
    }

}
