package com.example.aplicacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Comentarios extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ComentarioAdapter adapter;
    private List<Comentario> comentarios;
    private ImageView imagenEvento;
    private TextView tituloEvento;
    private TextView autorNombre;
    private TextView tvLikesCount;
    private TextView tvCommentCount;
    private ImageView ivLikeIcon;
    private ImageView ivCommentIcon;
    private EditText etCommentInput;
    private ImageView ivPhotoUpload;
    private ImageView ivPostComment;

    private int likesCount = 100;  //
    private int commentCount = 50; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);


        recyclerView = findViewById(R.id.recyclerViewComentarios);
        imagenEvento = findViewById(R.id.ivEventImage);
        tituloEvento = findViewById(R.id.tvEventName);
        autorNombre = findViewById(R.id.tvAuthorName);
        tvLikesCount = findViewById(R.id.tvLikesCount);
        tvCommentCount = findViewById(R.id.tvCommentCount);
        ivLikeIcon = findViewById(R.id.ivLikeIcon);
        ivCommentIcon = findViewById(R.id.ivCommentIcon);
        etCommentInput = findViewById(R.id.etCommentInput);
        ivPhotoUpload = findViewById(R.id.ivPhotoUpload);
        ivPostComment = findViewById(R.id.ivPostComment);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        comentarios = new ArrayList<>();
        cargarComentarios();
        adapter = new ComentarioAdapter(comentarios);
        recyclerView.setAdapter(adapter);


        Intent intent = getIntent();
        int imagenResId = intent.getIntExtra("imagenEvento", 0);
        String tituloRes = intent.getStringExtra("tituloEvento");
        String autorRes = intent.getStringExtra("autorNombre");


        if (imagenResId != 0) {
            imagenEvento.setImageResource(imagenResId);
        }
        tituloEvento.setText(tituloRes);
        autorNombre.setText(autorRes);


        tvLikesCount.setText(String.valueOf(likesCount));
        tvCommentCount.setText(String.valueOf(commentCount));


        ivLikeIcon.setOnClickListener(view -> {
            likesCount++;
            tvLikesCount.setText(String.valueOf(likesCount));
            Toast.makeText(this, "Like agregado", Toast.LENGTH_SHORT).show();
        });


        ivPostComment.setOnClickListener(view -> {
            String comentario = etCommentInput.getText().toString();
            if (!comentario.isEmpty()) {
                comentarios.add(new Comentario("Usuario", comentario));
                adapter.notifyItemInserted(comentarios.size() - 1);
                etCommentInput.setText("");
                commentCount++;
                tvCommentCount.setText(String.valueOf(commentCount));
                Toast.makeText(this, "Comentario publicado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Escribe un comentario", Toast.LENGTH_SHORT).show();
            }
        });


        ivPhotoUpload.setOnClickListener(view -> {

            Toast.makeText(this, "Subir foto (funcionalidad aún no implementada)", Toast.LENGTH_SHORT).show();
        });
    }


    private void cargarComentarios() {
        comentarios.add(new Comentario("Felipe", "Evento muy bueno."));
        comentarios.add(new Comentario("Sofia", "Estuvo excelente!"));
        comentarios.add(new Comentario("Kevin", "Muy divertido"));
        comentarios.add(new Comentario("Elena", ":)"));
        comentarios.add(new Comentario("Felipe", "divertido"));
        comentarios.add(new Comentario("Sofia", "Estuvo excelente!"));

    }
}
