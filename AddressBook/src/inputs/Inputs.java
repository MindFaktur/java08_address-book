package inputs;

import utilities.Utilities;

public class Inputs {

    public static String getInput(String userField){
        System.out.println("Please enter " + userField);
        return Utilities.SC.next();
    }

}
