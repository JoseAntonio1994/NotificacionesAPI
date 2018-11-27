package com.android.notificacionesapi.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.notificacionesapi.DetalleActivity;
import com.android.notificacionesapi.R;
import com.android.notificacionesapi.model.NotiResponse;

import org.w3c.dom.Text;

import java.util.List;

public class NotificacionAdapter extends RecyclerView.Adapter<NotificacionAdapter.NotiHolder> {

    private Context context;
    private List<NotiResponse> list;

    public NotificacionAdapter(Context context, List<NotiResponse> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NotiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notificacion_item, parent, false);
        return new NotiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotiHolder holder, int position) {
        holder.fecha.setText(list.get(position).getFecha_evento());
        holder.unidad.setText(list.get(position).getId_unidad());
        holder.descripcion.setText(list.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotiHolder extends RecyclerView.ViewHolder {

        TextView fecha;
        TextView unidad;
        TextView descripcion;

        public NotiHolder(final View itemView) {
            super(itemView);

            fecha = (TextView) itemView.findViewById(R.id.txt_fecha);
            unidad = (TextView) itemView.findViewById(R.id.txt_nombreUnidad);
            descripcion = (TextView) itemView.findViewById(R.id.txt_descripcion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    NotiResponse clicked = list.get(pos);
                    Intent intent = new Intent(context, DetalleActivity.class);
                    intent.putExtra("nombre", list.get(pos).getId_unidad());
                    intent.putExtra("fecha", list.get(pos).getFecha_evento());
                    intent.putExtra("posicionX", list.get(pos).getPosition().get(0));
                    intent.putExtra("posicionY", list.get(pos).getPosition().get(1));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
