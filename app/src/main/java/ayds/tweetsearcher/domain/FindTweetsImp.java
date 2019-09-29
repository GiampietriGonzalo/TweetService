package ayds.tweetsearcher.domain;

import ayds.tweetsearcher.presentation.model.SearchTweetsInteractor;

 class FindTweetsImp implements FindTweets {

    private final TweetsRepository repository;
    private final SearchTweetsInteractor useCaseInteractor;

    FindTweetsImp(TweetsRepository repository, SearchTweetsInteractor useCaseInteractor){
        this.repository = repository;
        this.useCaseInteractor = useCaseInteractor;
    }

    public void execute(String username) {
        repository.findTweets(username,useCaseInteractor::onTweetsFound, useCaseInteractor::onError);
    }

}
