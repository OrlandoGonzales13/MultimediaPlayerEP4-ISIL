package com.example.multimediaplayerep4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Instanciamos los botones
    Button btnAudio;
    Button btnVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAudio = (Button) findViewById(R.id.btnAudio);
        btnVideo = (Button) findViewById(R.id.btnVideo);

        //Creamos los eventos: click para cada uno de los botones
        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //llamamos a la actividad: Audio
                Intent intent = new Intent(getApplicationContext(), Audio.class);
                startActivity(intent);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //llamamos a la actividad: Video
                Intent intent = new Intent(getApplicationContext(), Video.class);
                startActivity(intent);
            }
        });
    }
}