package com.shahid.d28_restapipost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.shahid.d28_restapipost.retrofit.ApiClient;
import com.shahid.d28_restapipost.retrofit.CustomAdapter;
import com.shahid.d28_restapipost.retrofit.RetrofitInterface;
import com.shahid.d28_restapipost.retrofit.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private List<User> userList;
    private RetrofitInterface retrofitInterface;
    private ProgressBar progressBar;

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

        Call<List<User>> call = retrofitInterface.getUser();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList = response.body();
                adapter = new CustomAdapter(userList);
                progressBar.setVisibility(View.GONE);
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
        progressBar = findViewById(R.id.progressbarID);


    }
}
