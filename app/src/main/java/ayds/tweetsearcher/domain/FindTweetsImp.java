package ayds.tweetsearcher.domain;

import ayds.tweetsearcher.domain.TweetsRepository.SearchErrorListener;
import ayds.tweetsearcher.domain.TweetsRepository.SearchListener;

class FindTweetsImp implements FindTweets {

    private final TweetsRepository repository;

    FindTweetsImp(TweetsRepository repository){
        this.repository = repository;
    }

    public void execute(String username, SearchListener listener, SearchErrorListener errorListener) {
        repository.findTweets(username, listener, errorListener);
    }

}
