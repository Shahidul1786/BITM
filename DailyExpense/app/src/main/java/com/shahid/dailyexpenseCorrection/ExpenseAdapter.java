package com.shahid.dailyexpenseCorrection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Expense expense = expenses.get(position);
        holder.date.setText(expense.getDate());
        holder.amount.setText(expense.getAmount());


    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView expense,date,amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            expense = itemView.findViewById(R.id.expenseTV);
            date = itemView.findViewById(R.id.dateTV);
            amount = itemView.findViewById(R.id.amountTV);
        }
    }
}
