package com.nts.bitm.labtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Data> movies;
    private RecyclerView movieRV;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initRecyclerView();
        getData();
    }

    private void getData() {

        movies.add(new Data("Titanic","James Cameroon",R.drawable.road));
        movies.add(new Data("Harry Porter","J.K. Rawling",R.drawable.download));
        movies.add(new Data("The Notebook","Nicolas Sparks ",R.drawable.road));
        movies.add(new Data("Forest Gump","Robert Zemeckis",R.drawable.download));
        movies.add(new Data("Shawshank Redemption","Frank Darabont",R.drawable.road));

        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {

        movieRV.setLayoutManager(new LinearLayoutManager(this));
        movieRV.setAdapter(adapter);
    }

    private void init() {
        movieRV = findViewById(R.id.movieRV);
        movies = new ArrayList<Data>();
        adapter = new CustomAdapter(movies,this);
    }
}
