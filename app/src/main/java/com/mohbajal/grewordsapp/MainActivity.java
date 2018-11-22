package com.mohbajal.grewordsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "bajal";
    JSONArray words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView word = findViewById(R.id.word);
        final TextView meaning = findViewById(R.id.meaning);
        final TextView sentence = findViewById(R.id.sentence);

        String fileContents = loadJSONFromAsset(this);

        try {
            words = new JSONArray(fileContents);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LinearLayout l1 = findViewById(R.id.lay);
        l1.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "onClick");
                JSONObject rec = null;
                try {
                    rec = words.getJSONObject(counter++);
                    word.setText(rec.getString("word"));
                    sentence.setText(rec.getString("passage"));
                    meaning.setText(rec.getString("definition"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("gre-vocabulary.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
