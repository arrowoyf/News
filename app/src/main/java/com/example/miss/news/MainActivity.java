package com.example.miss.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_splash);

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);

        finish();
    }
}