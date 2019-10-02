package ayds.tweetsearcher.presentation.view;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TweetView;
import java.util.List;
import ayds.tweetsearcher.presentation.presenter.ShowTweetsPresenter;
import ayds.tweetsearcher.R;

public class ShowTweetsViewImpl extends AppCompatActivity implements ShowTweetsView {

    private ShowTweetsPresenter presenter;
    private Button showTweetsButton;
    private LinearLayout myLayout;

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
        String buttonText = "Show latest tweets!";
        String userName ="elonmusk";

        Twitter.initialize(this);
        setContentView(R.layout.showtweets);
        showTweetsButton = findViewById(R.id.search_tweets);
        myLayout = findViewById(R.id.layout_tweets) ;
        showTweetsButton.setText(buttonText);
        showTweetsButton.setBackgroundColor(Color.BLUE);
        showTweetsButton.setTextColor(Color.WHITE);
        showTweetsButton.setOnClickListener(e -> presenter.searchTweets(userName));
    }

    public void showTweets( List<Tweet> tweets) {
        for (Tweet tweet : tweets) {
            runOnUiThread(() -> myLayout.addView(new TweetView(ShowTweetsViewImpl.this, tweet)));
        }
        runOnUiThread(() -> myLayout.setBackgroundColor(Color.RED));
    }

    public void showError() {
        String message = "Sorry, we couldn't find the artist";
        runOnUiThread(() -> Toast.makeText(this, message, Toast.LENGTH_LONG).show());
    }

}
