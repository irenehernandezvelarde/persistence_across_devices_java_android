package com.example.persistence_across_devices_java_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.renderscript.ScriptGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private Object InputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);

        try {
            OutputStream os = openFileOutput("dades.txt", MODE_PRIVATE);
            String message= "Hola que tal";
            os.write(message.getBytes());
            os.close();
            ActualizaLeerContenidoArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void ActualizaLeerContenidoArchivo(){
        File path = getFilesDir();
        File file = new File(path,"dades.txt");
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
        }
        TextView tv = (TextView)findViewById(R.id.texto);
        tv.setText(text.toString());
    }

  
}