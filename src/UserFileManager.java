import org.json.JSONObject;

import java.io.*;
public class UserFileManager {
    private static final String FILE_PATH = "src/userFiles/";
    public static void saveUser(User user) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH + user.getMyGMAIl() + ".json")){
            JSONObject jsonUser = new JSONObject();

            jsonUser.put("name", user.getMyNAME());
            jsonUser.put("lastName", user.getMyLASTNAME());
            jsonUser.put("age", user.getMyAGE());
            jsonUser.put("gmail", user.getMyGMAIl());
            jsonUser.put("password", user.getMyPASSWORD());

            fileWriter.write(jsonUser.toString());
            System.out.println("User saved to file: " + jsonUser.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
