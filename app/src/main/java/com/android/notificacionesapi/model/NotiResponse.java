package com.android.notificacionesapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NotiResponse {
    @SerializedName("nombre")
    private String id_unidad;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("fecha_crea")
    private String fecha_evento;
    @SerializedName("position")
    private List<String> position = new ArrayList<>();

    public NotiResponse(String id_unidad, String descripcion, String fecha_evento, List<String> position) {
        this.id_unidad = id_unidad;
        this.descripcion = descripcion;
        this.fecha_evento = fecha_evento;
        this.position = position;
    }

    public NotiResponse() {
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(String fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public List<String> getPosition() {
        return position;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }
}
