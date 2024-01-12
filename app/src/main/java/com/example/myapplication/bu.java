package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bu extends AppCompatActivity {
    private Button btn_chat;
    private Button btn_video;
    private Button btn_music;
    private Button btn_shopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bu);
        btn_chat = findViewById(R.id.btn_chat);
        btn_video = findViewById(R.id.btn_vedio);
        btn_music = findViewById(R.id.btn_music);
        btn_shopping = findViewById(R.id.btn_shopping);
        btn_chat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bu.this, ChatActivity.class);
                startActivity(intent);
            }
        });
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bu.this, VideoActivity.class);
                startActivity(intent);
            }
        });
        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bu.this, MusicActivity.class);
                startActivity(intent);
            }
        });
        btn_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bu.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });
    }
}