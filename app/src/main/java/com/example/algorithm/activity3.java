package com.example.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
    }
    public void linearbutton(View v) {
        Intent newpage=new Intent(this,linear.class);
        startActivity(newpage);
    }public void binarybutton(View v) {
        Intent newpage=new Intent(this,binary.class);
        startActivity(newpage);

    }
}
