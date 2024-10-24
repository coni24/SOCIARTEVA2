package com.example.aplicacion;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView rvPostGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        rvPostGrid = findViewById(R.id.rvPostGrid);


        rvPostGrid.setLayoutManager(new GridLayoutManager(this, 3));


        List<Integer> postImages = new ArrayList<>();
        postImages.add(R.drawable.img1);
        postImages.add(R.drawable.img2);
        postImages.add(R.drawable.img3);
        postImages.add(R.drawable.img4);
        postImages.add(R.drawable.img5);


        PostAdapter adapter = new PostAdapter(postImages);
        rvPostGrid.setAdapter(adapter);
    }
}
