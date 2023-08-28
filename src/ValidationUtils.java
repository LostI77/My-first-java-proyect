import javax.swing.*;
public class ValidationUtils {

    public static boolean printValidationMessage(String input, String reference, String input2, String reference2, String maxReference) {
       if (input.length() >= reference.length()) {
           return true;
       } else if (input2.length() >= reference2.length()) {
           return true;
       }
       if (input.length() >= maxReference.length()) {
           return false;
       } else if (input2.length() >= maxReference.length()) {
           return false;
       } else {
           return true;
       }
    }

    public static boolean printVerifyIngUser(int input, int[] reference) {
        return input <= reference[0] || input >= reference[1];
    }

    public static String printVerifyGiftRegister(int input, int[] reference, String field, String[] myGift) {
        if (input < 30) {
            if (input >= reference[2]) {
                System.out.println("Your " + field + " is valid, we will give you a gift");
                return myGift[0];
            } else {
                System.out.println("Your " + field + " is not valid for the gift");
            }
        } else {
            if (input >= reference[3]) {
                System.out.println("Your " + field + " is valid, check your gift box");
                return myGift[1];
            } else {
                System.out.println("Your " + field + " is not valid for the gift.");
            }
        }
        return "No condition matched";
    }
}
