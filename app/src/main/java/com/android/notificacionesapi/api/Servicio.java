package com.android.notificacionesapi.api;

import com.android.notificacionesapi.model.NotiResponse;
import com.android.notificacionesapi.model.Notificaciones;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface Servicio {

    @GET("{client}")
    Call<List<NotiResponse>> getData(@Path("client") String id);
}
