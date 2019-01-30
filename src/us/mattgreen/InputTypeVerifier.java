
package us.mattgreen;

import java.util.Scanner;

/**
 *
 * @author tquigley1
 * 
 * The purpose of this class is to verify the type of animal
 */
public class InputTypeVerifier {

public InputTypeVerifier() {
    
}

public void verifyInput(String input) throws Exception {
   
    if ((!input.equalsIgnoreCase("cat"))
    && (!input.equalsIgnoreCase("dog"))
    && (!input.equalsIgnoreCase("student"))
    && (!input.equalsIgnoreCase("quit"))) {
        throw new Exception("Invalid input");
    }
}

}
    