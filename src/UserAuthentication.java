import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserAuthentication {
    public static boolean authenticationUser(String inputUserName, String inputGmail, String inputPassword) {
        String filePath = "./src/userFiles/"+ inputUserName +".json";

        File file = new File(filePath);

        if(file.exists()) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                JSONObject jsonUser = new JSONObject(content);

                String savedGmail = jsonUser.optString("gmail");
                String savedPassword = jsonUser.optString("password");

                if (savedGmail != null && savedPassword != null) {
                    return savedGmail.equals(inputGmail) && savedPassword.equals(inputPassword);
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("[Valores no encontrados]");
        }
        return false;
    }
}