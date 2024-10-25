package com.example.aplicacion;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.HashMap;
import java.util.Map;

public class Profile extends AppCompatActivity {

    private final Map<Integer, Class<?>> activityMap = new HashMap<>();
    private int currentActivityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        currentActivityId = R.id.navigation_profile;


        activityMap.put(R.id.navigation_home, home2.class);
        activityMap.put(R.id.navigation_search, search.class);
        activityMap.put(R.id.navigation_add, NuevaPublicacion.class);
        activityMap.put(R.id.navigation_calendar, Calendario.class);
        activityMap.put(R.id.navigation_profile, Profile.class);  // Esta es la actual


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();


            if (itemId == currentActivityId) {
                return true;
            }


            currentActivityId = itemId;


            Class<?> activityClass = activityMap.get(itemId);
            if (activityClass != null) {

                startActivity(new Intent(Profile.this, activityClass));
                return true;
            }
            return false;
        });
    }
}
