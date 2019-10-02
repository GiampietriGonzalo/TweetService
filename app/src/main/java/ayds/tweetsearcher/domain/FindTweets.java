package ayds.tweetsearcher.domain;

import ayds.tweetsearcher.domain.TweetsRepository.SearchErrorListener;
import ayds.tweetsearcher.domain.TweetsRepository.SearchListener;

public interface FindTweets {
    void execute(String username, SearchListener listener, SearchErrorListener errorListener);
}
