package ArraylistOfUserDefine;

import java.util.ArrayList;
import java.util.List;

public class Person {

    public String firstName;
    public String middleName;
    public String lastName;
    public Address personAddress;
    
    
     
    
    public String getFullName() {

        return firstName + " " + middleName + " " + lastName ;
    }

}
