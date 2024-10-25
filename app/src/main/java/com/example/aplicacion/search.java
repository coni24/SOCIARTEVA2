package com.example.aplicacion;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;
import java.util.Map;

public class search extends AppCompatActivity {

    private final Map<Integer, Class<?>> activityMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        activityMap.put(R.id.navigation_home, home2.class);
        activityMap.put(R.id.navigation_search, search.class);
        activityMap.put(R.id.navigation_add, NuevaPublicacion.class);
        activityMap.put(R.id.navigation_calendar, Calendario.class);
        activityMap.put(R.id.navigation_profile, Profile.class);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Class<?> activityClass = activityMap.get(item.getItemId());
            if (activityClass != null && activityClass != search.this.getClass()) {

                startActivity(new Intent(search.this, activityClass));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });


        bottomNavigationView.setSelectedItemId(R.id.navigation_search);
    }
}
