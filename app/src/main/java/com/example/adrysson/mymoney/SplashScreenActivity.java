package com.example.adrysson.mymoney;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                goMain();
            }
        }, 5000);
    }

    private void goMain() {
        Intent intent = new Intent(SplashScreenActivity.this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }
}
