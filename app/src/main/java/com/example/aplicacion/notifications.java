package com.example.aplicacion;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class notifications extends AppCompatActivity {

    private RecyclerView recyclerViewNotifications;
    private NotificationsAdapter notificationsAdapter;
    private List<noti_item> notificationsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        recyclerViewNotifications = findViewById(R.id.recyclerViewNotifications);
        recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(this));


        notificationsList = new ArrayList<>();
        notificationsList.add(new noti_item("kate", "Comentó tu publicación"));
        notificationsList.add(new noti_item("kate", "Le gustó tu publicación"));
        notificationsList.add(new noti_item("kate", "Te siguió"));
        notificationsList.add(new noti_item("kate", "Comentó tu publicación"));

        notificationsAdapter = new NotificationsAdapter(notificationsList);
        recyclerViewNotifications.setAdapter(notificationsAdapter);
    }
}