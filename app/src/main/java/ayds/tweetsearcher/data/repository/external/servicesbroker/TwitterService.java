package ayds.tweetsearcher.data.repository.external.servicesbroker;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;

public interface TwitterService {
    List<Tweet> findTweets(String query);
}
