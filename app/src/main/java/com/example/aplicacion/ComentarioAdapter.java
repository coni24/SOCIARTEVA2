package com.example.aplicacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComentarioAdapter extends RecyclerView.Adapter<ComentarioAdapter.ComentarioViewHolder> {

    private final List<Comentario> Comentarios;

    public ComentarioAdapter(List<Comentario> comentarios) {
        this.Comentarios = comentarios;
    }

    @NonNull
    @Override
    public ComentarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comentarios, parent, false);
        return new ComentarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentarioViewHolder holder, int position) {
        Comentario comentario = Comentarios.get(position);
        holder.tvNombreUsuario.setText(comentario.getNombreUsuario());
        holder.tvContenido.setText(comentario.getContenido());
    }

    @Override
    public int getItemCount() {
        return Comentarios.size();
    }

    static class ComentarioViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreUsuario;
        TextView tvContenido;

        public ComentarioViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreUsuario = itemView.findViewById(R.id.tvNombreUsuario);
            tvContenido = itemView.findViewById(R.id.tvContenido);
        }
    }
}
