package com.shahid.d25firebasecruddeatails;

public class Student {

    private String name;
    private String className;
    private String section;
    private  String roll;

    public Student() {
    }

    public Student(String name, String className, String section, String roll) {
        this.name = name;
        this.className = className;
        this.section = section;
        this.roll = roll;
    }


    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getSection() {
        return section;
    }

    public String getRoll() {
        return roll;
    }
}
