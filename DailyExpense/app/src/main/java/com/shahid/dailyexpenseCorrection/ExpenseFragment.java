package com.shahid.dailyexpenseCorrection;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenseFragment extends Fragment {

    private FloatingActionButton addFAB;
    private List<Expense> expenseList;
    private ExpenseAdapter adapter;
    private DatabaseHelper helper;
    private RecyclerView recyclerView;
    private FragmentManager fm;
    private TextView textViewOptions;
    private Context context;


    public ExpenseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expense, container, false);

        init(view);

        initRecyclerView();

        setdata();

        addFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout,new AddExpenseFragment());
                ft.commit();
            }
        });

        return view;
    }





    private void setdata() {

        Cursor cursor = helper.showData();

        while (cursor.moveToNext()){

            int id = cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String date = cursor.getString(cursor.getColumnIndex(helper.COL_DATE));
            String time = cursor.getString(cursor.getColumnIndex(helper.COL_TIME));
            String amount = cursor.getString(cursor.getColumnIndex(helper.COL_AMOUNT));
           // String type = cursor.getString(cursor.getColumnIndex(helper.COL_TYPE));

            expenseList.add(new Expense(id,amount,date,time));
            adapter.notifyDataSetChanged();
        }
    }



    private void initRecyclerView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void init(View view) {


        addFAB = view.findViewById(R.id.addFAB);
        recyclerView = view.findViewById(R.id.expenseRecyclerView);
        expenseList = new ArrayList<>();
        helper = new DatabaseHelper(getContext());
        adapter = new ExpenseAdapter(expenseList,getContext(),helper);

        textViewOptions = view.findViewById(R.id.textViewOption);
    }

}
