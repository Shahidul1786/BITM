package com.example.Recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initRecyclerview();

        setData();
    }

    private void setData() {
        movieList.add(new Movie("Avatar","James Cameroon",R.drawable.pc1));
        movieList.add(new Movie("Aladdin","Disney",R.drawable.pc2));
        movieList.add(new Movie("Kong:skull island","Grey archer",R.drawable.pc3));
        movieList.add(new Movie("Marvell","Avengers seies",R.drawable.pc4));
        movieList.add(new Movie("Cold Blood","peter jonson",R.drawable.pc6));
        adapter.notifyDataSetChanged();
    }

    private void initRecyclerview() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerviewID);
        movieList = new ArrayList<Movie>();

        adapter = new CustomAdapter(this,movieList);

    }
}
