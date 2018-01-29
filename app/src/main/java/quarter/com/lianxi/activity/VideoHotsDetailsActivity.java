package quarter.com.lianxi.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import quarter.com.lianxi.R;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class VideoHotsDetailsActivity extends AppCompatActivity {
    private IjkVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_video_hots_details);
        initView();

    }

    private void initView() {
        IjkMediaPlayer.loadLibrariesOnce(null);

        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        videoView = (IjkVideoView) findViewById(R.id.ijkPlayer);
        Intent intent = getIntent();
        String mv = intent.getStringExtra("mv");
        AndroidMediaController controller = new AndroidMediaController(this, false);
        videoView.setMediaController(controller);
        String url = mv;
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }


}
