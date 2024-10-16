package com.example.aplicacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CalendarExten extends DialogFragment {

    private CalendarView calendarView;

    public CalendarExten() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exten_calendar, container, false);
        calendarView = view.findViewById(R.id.calendar_view);

        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            ((Calendario) getActivity()).loadEventsForDate(date);
            dismiss();
        });

        return view;
    }
}
