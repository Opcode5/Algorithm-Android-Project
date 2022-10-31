package com.example.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
    }
    public void bubblebutton(View v) {
        Intent newpage=new Intent(this,bubble.class);
        startActivity(newpage);
    }public void countingbutton(View v) {
        Intent newpage=new Intent(this,counting.class);
        startActivity(newpage);
    }
    public void insertionbutton(View v) {
        Intent newpage=new Intent(this,insertion.class);
        startActivity(newpage);
    }
    public void selectionbutton(View v) {
        Intent newpage=new Intent(this,selection.class);
        startActivity(newpage);
    }
}
