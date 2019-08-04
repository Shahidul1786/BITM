package com.example.tourmate.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tourmate.R;
import com.example.tourmate.WeatherUtils.ForecastWeather.ForecasetWeather;
import com.example.tourmate.WeatherUtils.ForecastWeather.List;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ForcastAdapter extends RecyclerView.Adapter<ForcastHolder> {
    private ForecasetWeather forecasetWeather;
    public ForcastAdapter(ForecasetWeather forecasetWeather) {
        this.forecasetWeather = forecasetWeather;
    }

    @NonNull
    @Override
    public ForcastHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ForcastHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.forcast_weather_row,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ForcastHolder holder, int position) {
        List list = forecasetWeather.getList().get(position);
        holder.tempTV.setText(String.valueOf(list.getTemp().getDay()));
        holder.humTV.setText(String.valueOf(list.getHumidity()));


        Log.i("Time Long",list.getDt().toString());
        DateFormat simpleDateFormat = new SimpleDateFormat("dd MMM");
        Date date = new Date(list.getDt()*1000);
        String day__ = simpleDateFormat.format(date);
        holder.day.setText(day__);

    }

    @Override
    public int getItemCount() {
        return forecasetWeather.getList().size();
    }
}
class ForcastHolder extends RecyclerView.ViewHolder {
    TextView tempTV;
    TextView humTV;
    TextView day;

    public ForcastHolder(View itemView) {
        super(itemView);
        tempTV = itemView.findViewById(R.id.textView);
        humTV = itemView.findViewById(R.id.textView3);
        day = itemView.findViewById(R.id.textView4);
    }
}
