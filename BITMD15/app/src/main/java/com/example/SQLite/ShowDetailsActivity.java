package com.example.SQLite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private DatabaseHelper helper;
    private List<User> users ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        init();

        Cursor cursor = helper.showData();

        while (cursor.moveToNext()){

            int id = cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
            String age = cursor.getString(cursor.getColumnIndex(helper.COL_AGE));

            users.add(new User(id,name,age));

            adapter.notifyDataSetChanged();




        }
    }

    private void init() {

        recyclerView = findViewById(R.id.recyclerviewID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        helper = new DatabaseHelper(this);

        users = new ArrayList<>();

        adapter = new UserAdapter(this,users);

        recyclerView.setAdapter(adapter);








    }
}
