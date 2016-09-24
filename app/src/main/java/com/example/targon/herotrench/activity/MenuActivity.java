package com.example.targon.herotrench.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.targon.herotrench.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void createCustomGame(View view) {
        //Intent intent = new Intent(this, GameActivity.class);
        //intent.putExtra(GameActivity.KEY_LVL, GameActivity.CUSTOM);
        //startActivity(intent);
    }

    public void createApocalypseGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(GameActivity.KEY_LVL, GameActivity.APOCALYPSE);
        startActivity(intent);
    }
}
