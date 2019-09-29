package ayds.tweetsearcher.data.repository.external.servicesbroker;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;
import retrofit2.Call;
import retrofit2.Response;
import java.util.LinkedList;
import java.util.List;

class TwitterServiceImp implements TwitterService {

  public List<Tweet> findTweets(String query) {
      SearchService searchService =   TwitterCore.getInstance().getApiClient().getSearchService();
      Call<Search> search = searchService.tweets(
              query, null, null,
              null, null, 20,
              null, null, null, false);
        List<Tweet> tweets = new LinkedList<>();

      try {
          Response<Search> result = search.execute();
          tweets = result.body().tweets;
      } catch(Exception e) {
          System.out.println(e.getMessage());
      }
      return tweets;
    }
}
