package com.android.notificacionesapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private TextView titulo, nombre, fecha, posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        titulo = (TextView) findViewById(R.id.det_titulo);
        nombre = (TextView) findViewById(R.id.det_nombre);
        fecha = (TextView) findViewById(R.id.det_fecha);
        posicion = (TextView) findViewById(R.id.det_posicion);

        this.setTitle("Detalle de notificación");

        Intent intent = getIntent();

        if (intent != null){
            String tit = getIntent().getExtras().getString("nombre");
            String fecha_a = getIntent().getExtras().getString("fecha");
            String posX = getIntent().getExtras().getString("posicionX");
            String posY = getIntent().getExtras().getString("posicionY");
            String coor = posX + "," + posY;

            titulo.setText(tit);
            nombre.setText(tit);
            fecha.setText(fecha_a);
            posicion.setText(coor);
        }
    }
}
