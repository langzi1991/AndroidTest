package com.example.mac.androidtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @InjectView(R.id.OKHttp)
    Button OKHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        OKHttp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url("http://baidu.com").build();
        Response response = null;

        try {
            response = okHttpClient.newCall(request).execute();
            Log.e("MainActivity", "response = " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
