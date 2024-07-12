package com.example.multimediaplayerep4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Video extends AppCompatActivity {
    VideoView videoView;
    Button btnIniciar;
    ListView videoListView;
    String[] videoList = {"jujutsukaisenvideo", "ataquedetitanesvideo", "pokemonvideo", "pokemomjohtovideo", "digimonvideo", "narutovideo", "narutoshipudenvideo", "avatarvideo", "phineasyferbvideo", "bobesponjavideo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnIniciar = findViewById(R.id.btnIniciar);
        videoView = findViewById(R.id.videoView);
        videoListView = findViewById(R.id.videoListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, videoList);
        videoListView.setAdapter(adapter);

        videoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ruta = "android.resource://com.example.multimediaplayerep4/" + getResources().getIdentifier(videoList[position], "raw", getPackageName());
                videoView.setMediaController(new MediaController(Video.this));
                videoView.setVideoPath(ruta);
                videoView.start();
                videoView.requestFocus();
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Reproducir el primer video de la lista por defecto
                String ruta = "android.resource://com.example.multimediaplayerep4/" + getResources().getIdentifier(videoList[0], "raw", getPackageName());
                videoView.setMediaController(new MediaController(Video.this));
                videoView.setVideoPath(ruta);
                videoView.start();
                videoView.requestFocus();
            }
        });

        // Botón para retroceder a la pantalla principal
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Esto manejará el comportamiento estándar de retroceso
            }
        });
    }
}
