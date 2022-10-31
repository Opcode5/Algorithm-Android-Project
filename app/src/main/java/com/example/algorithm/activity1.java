package com.example.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.lang.annotation.Native;

public class activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

    }
    public void bfsbutton(View v) {
        Intent newpage=new Intent(this,bfs.class);
        startActivity(newpage);
    }
    public void dfsbutton(View v) {
        Intent newpage=new Intent(this,dfs.class);
        startActivity(newpage);
    }
    public void topsortbutton(View v) {
        Intent newpage=new Intent(this,topsort.class);
        startActivity(newpage);
    }
    public void bstbutton(View v) {
        Intent newpage=new Intent(this,bst.class);
        startActivity(newpage);
    }
    public void mstbutton(View v) {
        Intent newpage=new Intent(this,mst.class);
        startActivity(newpage);
    }
}
