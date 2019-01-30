
package us.mattgreen;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/**
 *
 * @author tquigley1
 * 
 * The purpose of this class is to facilitate user input for the animals project.
 */
public class UserInput {

public UserInput() {
    
}

public int getCatKills(String mousesKilled) throws NumberFormatException, Exception {
   
    int numKilled = 0;
    
    try {
        numKilled = Integer.parseInt(mousesKilled);
        if (numKilled < 0) {
            throw new Exception("Mouses killed cannot be negative");
        } else {
            return numKilled;
        }
    }
    catch (NumberFormatException e) {
        System.out.println("Invalid input for mouses killed");
    }
    return numKilled; 
}
    
public void getDogFriendly(String dogFriendly) throws Exception {
    
    if (!dogFriendly.equalsIgnoreCase("true")
    && (!dogFriendly.equalsIgnoreCase("false"))) {
        throw new Exception("Invalid valid for friendly");
    }
}  

public int getStudentAge(String age) throws NumberFormatException, Exception {
    
    int studentAge = 0;
    
    try {
        studentAge = Integer.parseInt(age);
        if (studentAge < 0) {
            throw new Exception("Student age cannot be negative");
        } else {
            return studentAge;
        }
    }
    catch (NumberFormatException e) {
        System.out.println("Invalid input for age");
    }
    return studentAge;
}

}
