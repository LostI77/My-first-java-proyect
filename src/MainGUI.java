import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.security.*;
import java.util.ArrayList;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame registerFrame = createRegisterFrame();
            JFrame loginFrame = createLoginFrame(registerFrame);
            JFrame userFrame = createUserFrame(loginFrame);
            registerFrame.setVisible(true);
        });
    }
    private static JFrame createRegisterFrame() {
        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 15));

        JTextField nameField = new JTextField(15);
        JTextField lastNameField = new JTextField(15);
        JTextField gmailField = new JTextField(15);
        JTextField ageField = new JTextField(5);
        JPasswordField passwordField = new JPasswordField();
        JButton validateButton = new JButton("Validate");

        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        validateButton.setFont(buttonFont);
        validateButton.setBackground(Color.blue);
        validateButton.setForeground(Color.white);

        validateButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        validateButton.setFocusPainted(false);

        validateButton.setOpaque(true);
        validateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered (java.awt.event.MouseEvent evt) {
                validateButton.setBackground(Color.cyan);
            }
            public void mouseExited (java.awt.event.MouseEvent evt) {
                validateButton.setBackground(Color.blue);
            }
        });

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameValue = nameField.getText();
                String lastNameValue = lastNameField.getText();
                String ageValue = ageField.getText();
                String gmailValue = gmailField.getText();

                char[] passwordChars = passwordField.getPassword();
                String passwordValue = new String(passwordChars);

                String myName = nameField.getText();
                String myLastName = lastNameField.getText();
                String myPassword= new String(passwordChars);
                String myGmail = gmailField.getText();

                String txtName = "ABCD";
                String txtLastName = "AB";
                String txtMaxCharaters = "ABCDEFGHIJKEEE";
                String txtPasswordMin = "ABCD";
                String txtPasswordMax = "AAAAAAAAAAAAAAA";
                String regexGmail = "^[A-Za-z0-9+_.-]+@(.+)$";
                String regexPass = "^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$";

                String[] myGift = {"Bueno, tenemos un regalo para ti", "Revisa tu buzon, tenemos un regalo para ti"};

                int myAge = Integer.parseInt(ageField.getText());
                int[] testAge = {13, 18, 22, 30};

                ValidationUtils.printValidationMessage(myName, txtName, myLastName, txtLastName, txtMaxCharaters);
                ValidationUtils.printVerifyIngUser(myAge, testAge);
                ValidationUtils.printVerifyGiftRegister(myAge, testAge, "age", myGift);
                ValidationUtils.printVerifyGmail(myGmail, regexGmail);
                ValidationUtils.printVerifyPassword(myPassword, txtPasswordMin, txtPasswordMax, regexPass);

                if (!nameValue.isEmpty() && !lastNameValue.isEmpty() && !ageValue.isEmpty() && !passwordValue.isEmpty() && !gmailValue.isEmpty()) {
                    if(!ValidationUtils.printValidationMessage(myName, txtName, myLastName, txtLastName, txtMaxCharaters)) {
                        JOptionPane.showMessageDialog(frame, "El nombre y el apellido deben tener mas de 4 a 2 caracteres y ser menor de 15 caracteres");
                        nameField.setText("");
                        lastNameField.setText("");
                    } else if (!ValidationUtils.printVerifyIngUser(myAge, testAge)) {
                        JOptionPane.showMessageDialog(frame, "No tienes la edad para registrarte");
                        ageField.setText("");
                    } else if(!ValidationUtils.printVerifyGmail(myGmail, regexGmail)) {
                        JOptionPane.showMessageDialog(frame, "Ingrese un Gmail valido");
                    } else if(!ValidationUtils.printVerifyPassword(myPassword, txtPasswordMin, txtPasswordMax, regexPass)) {
                        JOptionPane.showMessageDialog(frame, "La contraseña no es correcta");
                        gmailField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Registro completado");
                        JFrame resultFrame = new JFrame("¡Te has registrado exitosamente!");
                        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        resultFrame.setLayout(new BorderLayout());

                        JPanel infoPanel = new JPanel();
                        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

                        JLabel titleLabel = new JLabel("Tu informacion:");
                        infoPanel.add(titleLabel);

                        JLabel infolabel = new JLabel("Nombre y apellido: " + myName + " " + myLastName);
                        infoPanel.add(infolabel);

                        JLabel gmailLabel = new JLabel("Gmail: " + myGmail);
                        infoPanel.add(gmailLabel);

                        JLabel ageLabel = new JLabel("Edad: " + myAge);
                        infoPanel.add(ageLabel);

                        String giftText = ValidationUtils.printVerifyGiftRegister( myAge,testAge, "age",myGift);

                        JLabel giftLabel = new JLabel(giftText);
                        infoPanel.add(giftLabel);

                        frame.setVisible(false);
                        resultFrame.add(infoPanel, BorderLayout.CENTER);
                        resultFrame.pack();
                        resultFrame.setVisible(true);
                        createLoginFrame(createRegisterFrame()).setVisible(true);

                        User newUser = new User(myName, myLastName,myAge,myGmail,myPassword);
                        UserFileManager.saveUser(newUser);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame,"Los campos estan vacios, por favor ingrese los valores que se exigen.");
                }
            }
        });

        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Last Name:"));
        frame.add(lastNameField);
        frame.add(new JLabel("Gmail"));
        frame.add(gmailField);
        frame.add(new JLabel("Age:"));
        frame.add(ageField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(validateButton);
        frame.pack();
        return frame;
    }
    private static JFrame createLoginFrame(JFrame registerFrame) {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField inputGmailField = new JTextField(15);
        JTextField inputPasswordField = new JTextField(15);
        JButton loginButton = new JButton("Login up");

        frame.add(new JLabel("Ingresar Gmail:"));
        frame.add(inputGmailField);
        frame.add(new JLabel("Ingresar Password:"));
        frame.add(inputPasswordField);
        frame.add(loginButton);
        return frame;
    }
    private static JFrame createUserFrame(JFrame userFrame) {
        JFrame frame = new JFrame("Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        return frame;
    }
}