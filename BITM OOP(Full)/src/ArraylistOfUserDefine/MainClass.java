package ArraylistOfUserDefine;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        
       

        Person person1 = new Person();
        person1.firstName = "Md.";
        person1.middleName = "Shahidul";
        person1.lastName = "Islam";



        Person person2 = new Person();
        person2.firstName = "Md.";
        person2.middleName = "Imran";
        person2.lastName = "hosen";
        
        
       
       
        List<Person> personList = new ArrayList<>();

        personList.add(person1);
        personList.add(person2);

        for (Person person : personList) {

            System.out.println(person.getFullName());

        }

        /*String fullName = person1.getFullName();
        System.out.println(fullName);

        Person person3 = person1;
        person3.firstName = "Shekh";
        String name = person1.getFullName();

        System.out.println(name);

        Person person2 = new Person();
        person2.firstName = "Md.";
        person2.middleName = "Imran";
        person2.lastName = "hosen";

        String fullName2 = person2.getFullName();
        System.out.println(fullName2);

        person2 = person1;
        person3 = null;


         */
    }
}
