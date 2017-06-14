package mr.rad.kg.kyrgyzstan;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import static java.security.AccessController.getContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class GimnFragment extends Fragment {

    MediaPlayer player;
    SurfaceView surface;
    SurfaceHolder holder;
    private YouTubePlayer YPlayer;

    public GimnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gimn, container, false);

        surface = (SurfaceView) view.findViewById(R.id.video);
        holder = surface.getHolder();
        final Button play = (Button) view.findViewById(R.id.play);
        Button stop = (Button) view.findViewById(R.id.stop);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    player = MediaPlayer.create(getContext(), R.raw.gimn);
                    player.setDisplay(holder);

                player.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( player != null && player.isPlaying() ) {
                    player.stop();
                    player.release();
                }
            }
        });

        return view;
    }

    public void play(View v) {
        MediaPlayer player = MediaPlayer.create(getContext(), R.raw.gimn);
        player.start();
    }

}
