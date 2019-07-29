package com.shahid.restapi2.retrofit;

public class User {

    private int postId;
    private int Id;
    private String name;
    private String email;
    private String body;

    public User() {
    }

    public User(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        Id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}


