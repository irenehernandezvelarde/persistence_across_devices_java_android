package com.example.persistence_across_devices_java_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        try{
            OutputStream os = openFileOutput("dades.txt", MODE_PRIVATE);
            String message= "hola que tal";
            os.write(message.getBytes());
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}