package com.shahid.dailyexpenseCorrection;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AddExpenseFragment extends Fragment {

    private EditText amountET,dateET,timeET;
    private Button addExpense;
    private DatabaseHelper helper;
    private String amount,date,time;
    private ImageView dateImage,timeImage;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public AddExpenseFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_add_expense, container, false);

        init(view);


        dateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });
        timeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimePicker();
            }
        });

        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amount = amountET.getText().toString();
                date = dateET.getText().toString();
                time = timeET.getText().toString();

                long id = helper.insertData(amount,date,time);

                Toast.makeText(getContext(), "data serial : "+id, Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }

    private void openTimePicker() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        View view = getLayoutInflater().inflate(R.layout.custom_time_picker,null);
        Button done = view.findViewById(R.id.doneBTN);
        final TimePicker timePicker = view.findViewById(R.id.timePicker);

        builder.setView(view);

        final Dialog dialog = builder.create();

        dialog.show();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");

                int hour = timePicker.getHour();
                int min = timePicker.getMinute();

                Time time = new Time(hour,min,0);

                timeET.setText(timeFormat.format(time));
                dialog.dismiss();

            }
        });


    }

    private void openDatePicker() {

        DatePickerDialog.OnDateSetListener dateSetListener  = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month+1;

                String pickedDate = year+"/"+month+"/"+day;
                Date date = null;

                try {

                    date = dateFormat.parse(pickedDate);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                dateET.setText(dateFormat.format(date));

            }
        };

        Calendar  calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),dateSetListener,year,month,day);

        datePickerDialog.show();

    }

    private void init(View view) {

        amountET = view.findViewById(R.id.amountET);
        dateET = view.findViewById(R.id.dateET);
        timeET = view.findViewById(R.id.timeET);
        addExpense = view.findViewById(R.id.addExpenseBTN);
        dateImage = view.findViewById(R.id.dateIV);
        timeImage = view.findViewById(R.id.timeIV);
        helper = new DatabaseHelper(getContext());

    }


}
