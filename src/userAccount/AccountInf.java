package userAccount;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AccountInf {

    public static JSONObject getUserJson(String accountName) {
        String filePath = "src/userFiles/" + accountName + ".json";
        System.out.println("Usuario logeaado: " + accountName + "\n");
        System.out.println("Direccion: " + filePath);

        try {
            String allUserInf = new String(Files.readAllBytes(Paths.get(filePath)));
            return new JSONObject(allUserInf);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
