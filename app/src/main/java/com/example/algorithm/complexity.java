package com.example.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class complexity extends AppCompatActivity {

    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complexity);

        t1= (TextView) findViewById(R.id.ttt);

        jsonTask jTask = new jsonTask();
        jTask.execute();

    }


    public class jsonTask extends AsyncTask<String,String,String> {


        @Override    protected String doInBackground(String... strings) {

            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader = null;
            String name;
            String complexity;
            String details;
            try {
                URL url = new URL("https://api.myjson.com/bins/goksg");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer=new StringBuffer();
                String line= "";
                StringBuffer lastBuffer = new StringBuffer();
                while((line=bufferedReader.readLine()) != null){

                    stringBuffer.append(line);

                }
                String file = stringBuffer.toString();


                JSONObject fileObject = new JSONObject(file);
                JSONArray jsonArray = fileObject.getJSONArray("algorithm");

                for(int i=0; i<jsonArray.length(); i++) {
                    JSONObject arrayObject = jsonArray.getJSONObject(i);
                    name = arrayObject.getString("name");
                    complexity= arrayObject.getString("complexity");
                    details = arrayObject.getString("details");

                    lastBuffer.append("Name: "+name+"\n"+"Complexity: "+complexity+"\n"+"Details: "+details+"\n\n");
                }
                return  lastBuffer.toString();



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                httpURLConnection.disconnect();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            return null;
        }

        @Override    protected void onPostExecute(String s) {
            super.onPostExecute(s);
            t1.setText(s);
        }
    }

}
