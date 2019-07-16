package com.shahid.dailyexpensenote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shahid.dailyexpensenote.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //private Button addExpense;
    //private FloatingActionButton fab;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //init();

        binding.fabID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddExpenseActivity.class));
            }
        });

        binding.showItemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ExpenseDatailsActivity.class));
            }
        });


    }

    //private void init() {

        //addExpense =findViewById(R.id.saveExpenseBTN);
        //fab  = findViewById(R.id.fabID);
    //}
}
