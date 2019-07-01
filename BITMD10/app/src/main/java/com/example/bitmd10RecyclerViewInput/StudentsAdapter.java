package com.example.bitmd10RecyclerViewInput;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    private ArrayList<Student> studentList;

    public StudentsAdapter(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }


    @NonNull
    @Override
    public StudentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

      View itemView =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_item_layout,viewGroup,false);

      ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.ViewHolder viewHolder, int i) {

        Student currentStudent = studentList.get(i);
        viewHolder.nameTV.setText(currentStudent.getName());
        viewHolder.idTV.setText(currentStudent.getId());
        viewHolder.genderTV.setText(currentStudent.getGender());
        viewHolder.emailTV.setText(currentStudent.getEmail());
        viewHolder.mobileNumberTV.setText(currentStudent.getMobileNumber());
        viewHolder.depTV.setText(currentStudent.getDept());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV,idTV,genderTV,emailTV,mobileNumberTV,depTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.nameTVID);
            idTV = itemView.findViewById(R.id.idTVID);
            genderTV = itemView.findViewById(R.id.genderTVID);
            emailTV = itemView.findViewById(R.id.emailTVID);
            mobileNumberTV = itemView.findViewById(R.id.mobileNumberTVID);
            depTV = itemView.findViewById(R.id.deptTVID);

        }
    }
}
