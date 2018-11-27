package com.android.notificacionesapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Notificaciones {
    
    private List<NotiResponse> responseList;

    public Notificaciones(List<NotiResponse> responseList) {
        this.responseList = responseList;
    }

    public Notificaciones() {
    }

    public List<NotiResponse> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<NotiResponse> responseList) {
        this.responseList = responseList;
    }
}
