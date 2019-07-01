package com.example.bitmd10RecyclerViewInput;

public class Student {

    String name;
    String id;
    String dept;
    String gender;
    String email;
    String mobileNumber;

    public Student() {
    }

    public Student(String name, String id, String dept, String gender, String email, String mobileNumber) {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDept() {
        return dept;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
