package ayds.tweetsearcher.data.repository;

import com.twitter.sdk.android.core.models.Tweet;
import ayds.tweetsearcher.data.repository.external.servicesbroker.TwitterService;
import ayds.tweetsearcher.domain.TweetsRepository;

import java.util.List;

class TweetsRepositoryImp implements TweetsRepository {

    private final TwitterService externalService;

    TweetsRepositoryImp(TwitterService externalService) {
        this.externalService = externalService;
    }

    @Override
    public void findTweets(String query, SearchListener listener, SearchErrorListener errorListener) {
        List<Tweet> tweets = externalService.findTweets(query);
        if (tweets.isEmpty()) {
            errorListener.onError();
        } else {
            listener.onFound(externalService.findTweets(query));
        }
    }

}
