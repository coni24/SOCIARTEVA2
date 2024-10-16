package com.example.aplicacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CalendarioAdapter extends RecyclerView.Adapter<CalendarioAdapter.EventViewHolder> {

    private Context context;
    private List<Event> eventList;

    public CalendarioAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_calendar, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.tvEventTitle.setText(event.getTitle());
        holder.tvEventTime.setText(event.getTime());
        holder.ivEventImage.setImageResource(event.getImageResId());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView tvEventTitle, tvEventTime;
        ImageView ivEventImage;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEventTitle = itemView.findViewById(R.id.tv_event_title);
            tvEventTime = itemView.findViewById(R.id.tv_event_time);
            ivEventImage = itemView.findViewById(R.id.iv_event_image);
        }
    }
}
