package com.shahid.dailyexpenseCorrection;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private String amount,date,time;

    private List<Expense> expenses;
    private Context context;
    private DatabaseHelper helper;

    public ExpenseAdapter(List<Expense> expenses, Context context, DatabaseHelper helper) {
        this.expenses = expenses;
        this.context = context;
        this.helper = helper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_user_expense_list,parent,false);

        ViewHolder holder = new ViewHolder(itemView);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final Expense expense = expenses.get(position);
        holder.date.setText(expense.getDate());
        holder.amount.setText(expense.getAmount());


        holder.textViewOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup = new PopupMenu(context,holder.textViewOptions);

                popup.inflate(R.menu.options_menu);

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {


                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){

                            case R.id.update:



                                Toast.makeText(context, "update", Toast.LENGTH_SHORT).show();
                               break;
                            case R.id.delete:
                                Toast.makeText(context, "update", Toast.LENGTH_SHORT).show();

                                break;
                        }

                        return false;
                    }
                });

                popup.show();

            }
        });



    }




    @Override
    public int getItemCount() {
        return expenses.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView expense,date,amount,time,textViewOptions;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            expense = itemView.findViewById(R.id.expenseTV);
            date = itemView.findViewById(R.id.dateTV);
            amount = itemView.findViewById(R.id.amountTV);
            time = itemView.findViewById(R.id.timeTV);

            textViewOptions = itemView.findViewById(R.id.textViewOption);




        }
    }
}
