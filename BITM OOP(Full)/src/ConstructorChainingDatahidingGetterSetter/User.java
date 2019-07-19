
package ConstructorChainingDatahidingGetterSetter;


public class User {
    
    //data hiding by using private
    
   private String id;
   private String name;
   private String email;
   private String gender;
   private String mobileNumber;
   private String address;

    public User() {
    }

  /*  public User(String id, String name, String email, String gender, String mobileNumber) {
        
        this(); // default construct0r;
        
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }
    
      public User(String id, String name, String email, String gender, String mobileNumber,String address) {
        
          this(id, name, email, gender, mobileNumber); // constructor chaining;
           
        this.address = address;
    }

*/
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
      
      
    
    
}
