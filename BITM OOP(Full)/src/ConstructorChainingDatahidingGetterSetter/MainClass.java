package ConstructorChainingDatahidingGetterSetter;

public class MainClass {

    public static void main(String[] args) {
        // User user =   new User("s100", "Shahid", "st@gmail.com", "Male", "0170000090","Dhanmondi-15");

        //After setter method
        User user = new User();
        user.setId("S100");
        user.setName("Shahid");
        user.setEmail("st@gmail.com");
        user.setGender("Male");
        user.setMobileNumber("01700000");
        user.setAddress("Dhanmondi-15");
        

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getGender());
        System.out.println(user.getMobileNumber());
        System.out.println(user.getAddress());

        //if (user.getAddress()!= null) {
        //   System.out.println(user.getAddress());
        //}
    }

}
