package com.android.notificacionesapi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.notificacionesapi.adaptadores.NotificacionAdapter;
import com.android.notificacionesapi.api.Cliente;
import com.android.notificacionesapi.api.Servicio;
import com.android.notificacionesapi.model.NotiResponse;
import com.android.notificacionesapi.model.Notificaciones;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<NotiResponse> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        //Toast.makeText(MainActivity.this, "Movies Refreshed", Toast.LENGTH_SHORT).show();

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {

        Cliente client = new Cliente();
        Servicio apiServicio = client.getClient().create(Servicio.class);
        Call<List<NotiResponse>> call = apiServicio.getData("5812a6cb19c7e3df94ff23ac");
        call.enqueue(new Callback<List<NotiResponse>>() {
            @Override
            public void onResponse(Call<List<NotiResponse>> call, Response<List<NotiResponse>> response) {
                List<NotiResponse> list = response.body();
                //Toast.makeText(getApplicationContext(), list.get(0).getDescripcion(), Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(new NotificacionAdapter(getApplicationContext(), list));
            }

            @Override
            public void onFailure(Call<List<NotiResponse>> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });

    }

}
