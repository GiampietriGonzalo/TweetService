package ayds.tweetsservice;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.LinkedList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

class TwitterServiceImp implements TwitterService {

  public List<Tweet> findTweets(String query) {
      List<Tweet> tweets = new LinkedList<>();

     Call<List<Tweet>> tweetsResult = TwitterCore.getInstance().getApiClient().getStatusesService().userTimeline(
              null, query, 20, null,
             null, false, false,
             false, false);

      try {
          Response<List<Tweet>> result = tweetsResult.execute();
          tweets = result.body();
      } catch(Exception e) {
          System.out.println(e.getMessage());
      }
      return tweets;
    }
}
