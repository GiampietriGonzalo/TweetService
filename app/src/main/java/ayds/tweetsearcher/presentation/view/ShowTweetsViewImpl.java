package ayds.tweetsSearcher.presentation.view;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetView;
import java.util.List;
import ayds.tweetsSearcher.presentation.presenter.ShowTweetsPresenter;
import ayds.tweetsSearcher.R;

public class ShowTweetsViewImpl extends AppCompatActivity implements ShowTweetsView {

    private ShowTweetsPresenter presenter;
    private Button showTweets;
    private LinearLayout myLayout;  //= (LinearLayout) findViewById(R.id.my_tweet_layout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        configureUI();
    }

    private void initPresenter() {
        ViewModule.getInstance().setView(this);
    }

    public void setPresenter(ShowTweetsPresenter presenter) {
        this.presenter = presenter;
    }

    private void configureUI() {
        Twitter.initialize(this);
        setContentView(R.layout.showtweets);
        showTweets = findViewById(R.id.search_tweets);
        myLayout = findViewById(R.id.layout_tweets) ;
        showTweets.setText("Show latest tweets!");
        showTweets.setBackgroundColor(Color.BLUE);
        showTweets.setTextColor(Color.WHITE);
        showTweets.setOnClickListener(e -> presenter.searchTweets("elonmusk"));
    }

    public void showTweets( List<Tweet> tweets) {
        for (Tweet tweet : tweets) {
            runOnUiThread(() -> myLayout.addView(new TweetView(ShowTweetsViewImpl.this, tweet)));
        }
        runOnUiThread(() -> myLayout.setBackgroundColor(Color.RED));
    }

}
