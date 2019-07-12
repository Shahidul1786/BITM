package com.shahid.dailyexpenseCorrection;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

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

                        int itemid = menuItem.getItemId();

                        boolean showMessage = false;

                        String message = "";
                        if (itemid == R.id.update){

                            Intent intent = new Intent(context,UpdateActivity.class);
                            context.startActivity(intent);

                        }
                        else if (itemid == R.id.delete){

                            helper = new DatabaseHelper(context);
                            helper.deleteData(expense.getId());
                            expenses.remove(position);
                            notifyDataSetChanged();

                            Toast.makeText(context, "delete ", Toast.LENGTH_SHORT).show();

                        }

                        return false;
                    }
                });

                popup.show();

            }
        });


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetailsActivity.class);
                //intent.putExtra("amount",expense.getAmount());
                //intent.putExtra("date",expense.getDate());
                //intent.putExtra("time",expense.getTime());
                context.startActivity(intent);

            }
        });



    }




    @Override
    public int getItemCount() {
        return expenses.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView expense,date,amount,time,textViewOptions;
        private CardView cardView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            expense = itemView.findViewById(R.id.expenseTV);
            date = itemView.findViewById(R.id.dateTV);
            amount = itemView.findViewById(R.id.amountTV);
            time = itemView.findViewById(R.id.timeTV);

            textViewOptions = itemView.findViewById(R.id.textViewOption);

            cardView = itemView.findViewById(R.id.cardViewID);




        }
    }
}
