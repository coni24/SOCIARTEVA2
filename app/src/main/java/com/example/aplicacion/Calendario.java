package com.example.aplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Calendario extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CalendarioAdapter calendarioAdapter;
    private List<Event> eventList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        recyclerView = findViewById(R.id.event_list);

        eventList = new ArrayList<>();
        calendarioAdapter = new CalendarioAdapter(this, eventList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(calendarioAdapter);


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

