package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.UiModeManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView banner;
    Button btnstart, btnend, mode;
    RelativeLayout rel;
    TextView title;
    boolean flag = true; // true -> Light Mode

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rel = findViewById(R.id.rel);
        title = findViewById(R.id.title);

        banner = findViewById(R.id.banner);
        btnstart = findViewById(R.id.start);
        btnend = findViewById(R.id.end);
        mode = findViewById(R.id.mode);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AsynchronousTask task = new AsynchronousTask();
                task.execute();
            }
        });

        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banner.setSelected(false);
                banner.setVisibility(View.INVISIBLE);
            }
        });

        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag) {
                    rel.setBackgroundResource(R.color.black);
                    title.setTextColor(Color.parseColor("#FFFFFF"));
                    flag = false;
                } else {
                    rel.setBackgroundResource(R.color.white);
                    title.setTextColor(Color.parseColor("#000000"));
                    flag = true;
                }
            }
        });


    }

    private class AsynchronousTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            Toast.makeText(MainActivity.this, "On Pre Execute", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            banner.setVisibility(View.VISIBLE);
            banner.setSelected(true);
//            Toast.makeText(MainActivity.this, "On Post Execute", Toast.LENGTH_SHORT).show();
        }


    }
}