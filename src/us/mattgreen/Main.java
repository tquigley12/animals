package us.mattgreen;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private final FileOutput outFile = new FileOutput("animals.txt");
    private final FileInput inFile = new FileInput("animals.txt");
    String animalType;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        ArrayList<Talkable> zoo = new ArrayList<>();

        // Lines to Replace
        // zoo.add(new Dog(true, "Pete"));
        // zoo.add(new Cat(9, "Anne Belly"));
        // zoo.add(new Student(19, "Joe John Johnson"));
        // End Lines to Replace
        
        // Create a keyboard Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        // Instantiate object to verify input type
        InputTypeVerifier typeVerifier = new InputTypeVerifier();
        
        // Instantiate object to provide methods to get user input
        UserInput userInput = new UserInput();
        
        /* Accept user input.  Valid values for animals are:
                                cat, dog, and student.
           Sentinel value for end of input is "quit".
        */
        
        boolean validInput;
        boolean quit = false;
        String animalType = "";
        String input = "";
        
        while (!quit) {
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Enter type of animal");
                    animalType = keyboard.nextLine();
                    typeVerifier.verifyInput(animalType);
                    validInput = true;
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            
            if (animalType.equalsIgnoreCase("cat")) {
                int mousesKilled = 0;
                String catName = "";
                System.out.println("This is a cat");
                validInput = false;
                while (!validInput) {
                    try {
                        System.out.println("Enter number of mouses killed");
                        input = keyboard.nextLine();
                        userInput.getCatKills(input);
                        validInput = true;
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Enter name of cat");
                catName = keyboard.nextLine();
                zoo.add(new Cat(mousesKilled, catName));
            } else if (animalType.equalsIgnoreCase("dog")) {
                boolean dogFriendly = false;
                String dogName = "";
                System.out.println("This is a dog");
                validInput = false;
                while (!validInput) {
                    try {
                        System.out.println("Dog is friendly?  True or False");
                        input = keyboard.nextLine();
                        userInput.getDogFriendly(input);
                        validInput = true;
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Enter name of dog");
                dogName = keyboard.nextLine();
                zoo.add(new Dog(dogFriendly, dogName));
            } else if (animalType.equalsIgnoreCase("student")) {
                int age = 0;
                String studentName = "";
                System.out.println("This is a student");
                validInput = false;
                while (!validInput) {
                    try {
                        System.out.println("Enter age of student");
                        input = keyboard.nextLine();
                        userInput.getStudentAge(input);
                        validInput = true;
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Enter name of student");
                studentName = keyboard.nextLine();
                zoo.add(new Student(age, studentName));
            } else {
                quit = true;
            }
        }
        
        for (Talkable thing : zoo) {
            printOut(thing);
        }
        outFile.fileClose();

        System.out.println("\n*** Reading/printing entire file using fileRead method\n");

        inFile.fileRead();
        inFile.fileClose();

        System.out.println("\n*** Reading/printing one line at a time using fileReadLine method\n");

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public void printOut(Talkable p) {
        System.out.println(p.getName() + " says = " + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
    }
}
