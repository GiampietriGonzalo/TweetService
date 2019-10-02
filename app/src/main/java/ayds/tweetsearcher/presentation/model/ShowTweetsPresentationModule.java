package ayds.tweetsearcher.presentation.model;

import ayds.tweetsearcher.domain.FindTweets;
import ayds.tweetsearcher.domain.UseCasesModule;
import ayds.tweetsearcher.presentation.presenter.ShowTweetsPresenter;

public class ShowTweetsPresentationModule {

    private static ShowTweetsPresentationModule instance;
    private ShowTweetsPresentationModule() {}

    public static ShowTweetsPresentationModule getInstance() {
        if (instance == null) {
            instance = new ShowTweetsPresentationModule();
        }
        return instance;
    }

    public SearchTweetsInteractor getUseCaseInteractor(ShowTweetsPresenter presenter) {
        SearchTweetsInteractor useCaseInteractor = new SearchTweetsInteractorImp(presenter);
        FindTweets useCase = UseCasesModule.getInstance().getFindTweetsUseCase();
        useCaseInteractor.setFindTweetsUseCase(useCase);

        return useCaseInteractor;
    }

}
