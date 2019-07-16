package com.shahid.dailyexpensenote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.shahid.dailyexpensenote.databinding.ActivityExpenseDatailsBinding;

public class ExpenseDatailsActivity extends AppCompatActivity {
    private ActivityExpenseDatailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_expense_datails);

       binding.backPressDetail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onBackPressed();
           }
       });
    }
}
