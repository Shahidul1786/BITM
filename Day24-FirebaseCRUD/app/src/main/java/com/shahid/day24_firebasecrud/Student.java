package com.shahid.day24_firebasecrud;

public class Student {

    public String name;
    public  String email;
    public  String bloodGroup;
    public String age;


    public Student() {
    }

    public Student(String name, String email, String bloodGroup, String age) {
        this.name = name;
        this.email = email;
        this.bloodGroup = bloodGroup;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getAge() {
        return age;
    }
}
