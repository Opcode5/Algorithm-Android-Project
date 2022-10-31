package com.example.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

public class kruskal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kruskal);
        //create scroll bar
        TextView tv=(TextView)findViewById(R.id.t2);
        tv.setMovementMethod(new ScrollingMovementMethod());

        final VideoView k=(VideoView) findViewById(R.id.kruskal);
        k.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.kruskal)) ;
        final ImageButton b=(ImageButton) findViewById(R.id.register);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!k.isPlaying()) b.setImageResource(R.drawable.start);
                if(k.isPlaying())
                {
                    k.pause();
                    b.setImageResource(R.drawable.start);
                }
                else
                {
                    k.start();
                    b.setImageResource(R.drawable.pause);

                }
            }
        });
        k.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                b.setImageResource(R.drawable.start);
            }
        });
    }
}
