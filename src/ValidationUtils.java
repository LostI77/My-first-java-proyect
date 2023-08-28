import javax.swing.*;
public class ValidationUtils {

    public static boolean printValidationMessage(String input, String reference) {
        return input.length() >= reference.length();
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
