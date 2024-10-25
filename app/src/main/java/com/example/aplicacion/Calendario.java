package com.example.aplicacion;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendario extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CalendarioAdapter calendarioAdapter;
    private List<Event> eventList;
    private final Map<Integer, Class<?>> activityMap = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);


        recyclerView = findViewById(R.id.event_list);
        eventList = new ArrayList<>();
        calendarioAdapter = new CalendarioAdapter(this, eventList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(calendarioAdapter);


        activityMap.put(R.id.navigation_home, home2.class);
        activityMap.put(R.id.navigation_search, search.class);
        activityMap.put(R.id.navigation_add, NuevaPublicacion.class);
        activityMap.put(R.id.navigation_calendar, Calendario.class);
        activityMap.put(R.id.navigation_profile, Profile.class);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Class<?> activityClass = activityMap.get(item.getItemId());
            if (activityClass != null && activityClass != Calendario.this.getClass()) {

                startActivity(new Intent(Calendario.this, activityClass));
                overridePendingTransition(0, 0);
                finish();
                return true;
            }
            return false;
        });


        bottomNavigationView.setSelectedItemId(R.id.navigation_calendar);


        findViewById(R.id.icon_calendar).setOnClickListener(v -> showCalendarDialog());
    }


    private void showCalendarDialog() {
        CalendarExten calendarDialogFragment = new CalendarExten();
        calendarDialogFragment.show(getSupportFragmentManager(), "calendarDialog");
    }


    public void loadEventsForDate(String date) {
        eventList.clear();
        eventList.add(new Event("Evento 1", "10:00 AM", R.drawable.img5));
        eventList.add(new Event("Evento 2", "01:00 PM", R.drawable.img3));
        calendarioAdapter.notifyDataSetChanged();
    }
}
