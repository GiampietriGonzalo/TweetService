package ayds.tweetsearcher.domain;

import ayds.tweetsearcher.data.repository.DataModule;
import ayds.tweetsearcher.presentation.model.SearchTweetsInteractor;

public class UseCasesModule {

    private static UseCasesModule instance;
    private UseCasesModule() {}

    public static UseCasesModule getInstance() {
        if (instance == null) {
            instance = new UseCasesModule();
        }
        return instance;
    }

    public FindTweets getFindTweetsUseCase(SearchTweetsInteractor interactor) {
        TweetsRepository repository = DataModule.getInstance().getExternalService();
        return new FindTweetsImp(repository,interactor);
    }
}
