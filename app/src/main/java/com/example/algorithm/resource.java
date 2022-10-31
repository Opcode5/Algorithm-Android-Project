package com.example.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class resource extends AppCompatActivity {
    String names[]={"www.geeksforgeeks.org","www.tutorialspoint.com","www.stackoverflow.com","www.cp-algorithms.com","www.hackerearth.com","www.hackerrank.com"};
    String description[]={"helpful for coding section","necessary for details","anyone can ask question","provide efficient algorithm","learn more details","provide algorithms with some practice problems"};
    int image[]={R.drawable.button,R.drawable.button,R.drawable.button,R.drawable.button,R.drawable.button,R.drawable.button};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        ListView listview=(ListView) findViewById(R.id.list);
        CustomAdapter customAdapter=new CustomAdapter();
        listview.setAdapter(customAdapter);
    }
    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.row,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.image);
            TextView textname=(TextView) view.findViewById(R.id.text1);
            TextView textdesc=(TextView) view.findViewById(R.id.text2);
            imageView.setImageResource(image[i]);
            textname.setText(names[i]);
            textdesc.setText(description[i]);
            return view ;
        }
    }


}
