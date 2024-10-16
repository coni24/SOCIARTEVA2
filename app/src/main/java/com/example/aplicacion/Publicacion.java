package com.example.aplicacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Publicacion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicacion);
    }

    public void verComment(View v){

        Intent intent = new Intent(this, Comentarios.class);
        intent.putExtra("imagenEvento", R.drawable.img3);
        intent.putExtra("tituloEvento", "Fiesta Ciudadana");
        intent.putExtra("autorNombre", "Emilia Young");
        startActivity(intent);
    }
}
