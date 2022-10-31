package com.example.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mst);
    }
    public void kruskalbutton(View v) {
        Intent newpage=new Intent(this,kruskal.class);
        startActivity(newpage);
    }
    public void primsbutton(View v) {
        Intent newpage=new Intent(this,prims.class);
        startActivity(newpage);
    }
}
