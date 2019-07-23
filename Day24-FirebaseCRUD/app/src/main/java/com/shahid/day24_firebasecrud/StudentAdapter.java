package com.shahid.day24_firebasecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> studentList;
    private Context context;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list,parent,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Student student = studentList.get(position);
        holder.name.setText(student.getName());
        holder.email.setText(student.getEmail());
        holder.age.setText(student.getAge());
        holder.bloodGroup.setText(student.getBloodGroup());


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name,email,age,bloodGroup;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTVID);
            email = itemView.findViewById(R.id.emailTVID);
            age = itemView.findViewById(R.id.ageTVID);
            bloodGroup = itemView.findViewById(R.id.bloodTVID);

        }
    }
}
