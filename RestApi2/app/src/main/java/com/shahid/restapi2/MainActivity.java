package com.shahid.restapi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shahid.restapi2.retrofit.ApiClient;
import com.shahid.restapi2.retrofit.CustomAdapter;
import com.shahid.restapi2.retrofit.RetrofitInterface;
import com.shahid.restapi2.retrofit.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RetrofitInterface retrofitInterface;
    private List<User> userList;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        initRecyclerview();

        getData();
    }

    private void getData() {

        retrofitInterface = ApiClient.getInstance().getApi();

        Call<List<User>> call = retrofitInterface.getUser(2);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                userList = response.body();
                adapter = new CustomAdapter(userList);
                recyclerView.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });


    }

    private void initRecyclerview() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void init() {

        recyclerView = findViewById(R.id.recyclerviewID);
        userList = new ArrayList<>();
        adapter = new CustomAdapter(userList);
    }
}
