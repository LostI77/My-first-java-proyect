import java.io.*;
public class UserFileManager {
    private static final String FILE_PATH = "./userFiles/";
    public static void saveUser(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(user);
            System.out.println("User saved to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
