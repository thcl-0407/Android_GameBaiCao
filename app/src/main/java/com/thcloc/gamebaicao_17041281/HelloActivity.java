package com.thcloc.gamebaicao_17041281;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        Button btnPlayingGame = (Button) findViewById(R.id.btnPlayingGame);
        btnPlayingGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}