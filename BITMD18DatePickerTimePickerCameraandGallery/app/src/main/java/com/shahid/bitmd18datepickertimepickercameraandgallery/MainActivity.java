package com.shahid.bitmd18datepickertimepickercameraandgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity {

    private Button datepickerBTN,timepickerBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        datepickerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });

        timepickerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openTimePicker();
            }
        });
    }

    private void openTimePicker() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.custom_time_picker,null);
         Button done = view.findViewById(R.id.doneBTNID);
        final TimePicker timePicker = view.findViewById(R.id.timepicker);

        builder.setView(view);

        final Dialog dialog = builder.create();
        dialog.show();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm aa ");
                int hour = timePicker.getHour();
                int min = timePicker.getMinute();

                Time time = new Time(hour,min,0);
                timepickerBTN.setText(timeformat.format(time));

                dialog.dismiss();


            }
        });


    }

    private void init() {
        datepickerBTN = findViewById(R.id.datepickerBTNID);
        timepickerBTN = findViewById(R.id.timepickerBTNID);

    }



    private void openDatePicker() {

      DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
          @Override
          public void onDateSet(DatePicker datePicker, int year, int month, int day) {

              month = month+1;

              String pickedDate =year+"/"+month+"/"+day+" 00:00:00";
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");

              Date date = null;

              try {
                  date= dateFormat.parse(pickedDate);
              } catch (ParseException e) {
                  e.printStackTrace();
              }

              datepickerBTN.setText(dateFormat.format(date));
          }
      };

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


    }




}
