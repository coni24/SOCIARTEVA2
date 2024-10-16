package com.example.aplicacion;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;
import java.util.Map;

public class home2 extends AppCompatActivity {

    private final Map<Integer, Class<?>> activityMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);


        activityMap.put(R.id.navigation_home, MainActivity.class);
        activityMap.put(R.id.navigation_search, search.class);
        activityMap.put(R.id.navigation_add, NuevaPublicacion.class);
        activityMap.put(R.id.navigation_calendar, Calendario.class);
        activityMap.put(R.id.navigation_profile, Perfil.class);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            Class<?> activityClass = activityMap.get(item.getItemId());
            if (activityClass != null) {
                startActivity(new Intent(home2.this, activityClass));
                finish();
                return true;
            }
            return false;
        });
    }
}
