package com.chennaicoderiders.fdastream;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class ExoVideoActivity extends AppCompatActivity {

    private static final String FRAGMENT_TAG = "main_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_video);

        FragmentManager fm = getFragmentManager();
        Fragment f = fm.findFragmentByTag(FRAGMENT_TAG);
        if(f == null){
            fm.beginTransaction().add(new MainFragment(), FRAGMENT_TAG).commit();
        }

    }

    public static class MainFragment extends Fragment {
        private SimpleExoPlayer player;
        private SurfaceView surfaceView;
        SimpleExoPlayerView playerView;
        //String videoURL = "https://archive.org/download/gullivers_travels1939/gullivers_travels1939_512kb.mp4";
        String videoURL = "http://bezzietech.com/aalaporan.mp4";
        BandwidthMeter bandwidthMeter;
        TrackSelector trackSelector;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
            initializePlayer();
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            playerView = getActivity().findViewById(R.id.video_view);
            playerView.setPlayer(player);
            Log.i(getTag(),"Setting player");
        }


        @Override
        public void onStart() {
            super.onStart();
            if(player == null){
                initializePlayer();
            }
        }

        @Override
        public void onStop() {
            super.onStop();
            if(getActivity().isChangingConfigurations()){
                Log.i(getTag(),"configuration is changing: keep playing");
            }
            else{
                player.release();
                Log.i(getTag(),"Releasing player");
            }
        }

        private void initializePlayer() {
            Log.i(getTag(),"Initializing player");
            int playbackPosition = 0;
            int currentWindow = 0;
            boolean playWhenReady;

            playWhenReady = true;

            playerView = getActivity().findViewById(R.id.video_view);

            player = ExoPlayerFactory.newSimpleInstance(
                    new DefaultRenderersFactory(getActivity()),
                    new DefaultTrackSelector(), new DefaultLoadControl());

            playerView.setPlayer(player);

            player.setPlayWhenReady(playWhenReady);
            player.seekTo(currentWindow, playbackPosition);


            Long id = getActivity().getIntent().getLongExtra("EXTRA_ID",-1);
            if(id == -1){
                id = 1L;
            }

            DBHandler dbHandler = new DBHandler(getActivity());
            Video video = dbHandler.getVideo(id);
            videoURL = video.get_url();

            Uri uri = Uri.parse(videoURL);
            MediaSource mediaSource = buildMediaSource(uri);

            player.prepare(mediaSource, true, false);
        }

        private MediaSource buildMediaSource(Uri uri){
            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(uri, dataSourceFactory, extractorsFactory, null, null);
            return mediaSource;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
