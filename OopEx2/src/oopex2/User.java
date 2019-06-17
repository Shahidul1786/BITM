/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopex2;

public class User {

    private String id;
    private String name;
    private String email;
    private String gender;
    private String mobileNumber;
    private String address;

    public User() {
    }

    public User(String id, String name, String email, String gender, String mobileNumber) {
        this();
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }

    public User(String id, String name, String email, String gender, String mobileNumber,String address) {
        
        this(id, name, email, gender, mobileNumber);
        
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.address = address;
        
        
      
              
     
      
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }
    
    
    

}
