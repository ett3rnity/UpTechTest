package alexanderivanets.uptechtest.view.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import alexanderivanets.uptechtest.R;
import alexanderivanets.uptechtest.model.Config;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alexander on 09.10.17.
 */

public class VideoPlaybackView extends AppCompatActivity{
    @BindView(R.id.wv_player)
    WebView player;

    private String videoURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        getIntentExtras();
        setVideoView();

    }



    private void getIntentExtras(){
        Intent intent = getIntent();
        videoURL = intent.getStringExtra(Config.VIDEO_URL);
        Log.v("VIDEO URL", videoURL);
    }


    private void setVideoView() {
        player.setWebChromeClient(new WebChromeClient());
        player.setWebViewClient(new WebViewClient());
        player.getSettings().setJavaScriptEnabled(true);
        player.loadUrl(videoURL);
    }


}
