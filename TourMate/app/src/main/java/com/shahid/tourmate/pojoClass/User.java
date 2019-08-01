package com.shahid.tourmate.pojoClass;

public class User {
    private String uid;
    private String name;
    private String email;
    private String phone;
    private String imgURL;

    public User() {
    }

    public User(String uid, String name, String email, String phone, String imgURL) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.imgURL = imgURL;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getImgURL() {
        return imgURL;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
