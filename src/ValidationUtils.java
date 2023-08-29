import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ValidationUtils {

    public static boolean printValidationMessage(String nameInput, String txtName, String lastNameInput, String txtLastName, String maxCharacters) {
        int minLengthName = txtName.length();
        int minLengthLastName = txtLastName.length();

        if(nameInput.length() >= minLengthName && lastNameInput.length() >= minLengthLastName && nameInput.length() <= maxCharacters.length()  && lastNameInput.length() <= maxCharacters.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean printVerifyIngUser(int input, int[] reference) {
        if(input < reference[1]){
            return false;
        } else {
            return true;
        }
    }

    public static boolean printVerifyGmail(String gmail, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(gmail);

        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean printVerifyPassword(String password, String minCharacters, String maxCharacters, String regex) {
        if(password.length() >= minCharacters.length() && password.length() <= maxCharacters.length() && Pattern.matches(regex, password)) {
            return true;
        } else {
            return false;
        }
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
