import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::createAndShowGUi);
    }
    private static void createAndShowGUi() {
        JFrame frame = new JFrame("Validation and Gift Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 15));

        JTextField nameField = new JTextField(15);
        JTextField lastNameField = new JTextField(15);
        JTextField ageField = new JTextField(5);
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

                if (!nameValue.isEmpty() && !lastNameValue.isEmpty() && !ageValue.isEmpty()) {
                    String myName = nameField.getText();
                    String myLastName = lastNameField.getText();
                    String txtName = "ABCD";
                    String txtLastName = "AB";
                    String[] myGift = {"Bueno, tenemos un regalo para ti", "Revisa tu buzon, tenemos un regalo para ti"};
                    int myAge = Integer.parseInt(ageField.getText());
                    int[] testAge = {13, 18, 22, 30};

                    ValidationUtils.printValidationMessage(myName, txtName);
                    ValidationUtils.printValidationMessage(myLastName, txtLastName);
                    ValidationUtils.printVerifyIngUser(myAge, testAge);
                    ValidationUtils.printVerifyGiftRegister(myAge, testAge, "age", myGift);

                    boolean isNameValid =  ValidationUtils.printValidationMessage(myName, txtName);
                    boolean isAgeValid = ValidationUtils.printVerifyIngUser(myAge, testAge);

                    if(!isNameValid) {
                        JOptionPane.showMessageDialog(frame, "El nombre debe tener minimo 4 caracteres y el apellido 2 caracteres minimo");
                    }
                    if(!isAgeValid) {
                        JOptionPane.showMessageDialog(frame, "No tienes la edad para registrarte");
                    }
                    if(isNameValid && isAgeValid) {
                        JFrame resultFrame = new JFrame("¡Te has registrado exitosamente!");
                        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        resultFrame.setLayout(new BorderLayout());

                        JPanel infoPanel = new JPanel();
                        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

                        JLabel titleLabel = new JLabel("Tu informacion:");
                        infoPanel.add(titleLabel);

                        JLabel infolabel = new JLabel("Nombre y apellido: " + myName + " " + myLastName);
                        infoPanel.add(infolabel);

                        JLabel ageLabel = new JLabel("Edad: " + myAge);
                        infoPanel.add(ageLabel);

                        String giftText = ValidationUtils.printVerifyGiftRegister( myAge,testAge, "age",myGift);

                        JLabel giftLabel = new JLabel(giftText);
                        infoPanel.add(giftLabel);

                        resultFrame.add(infoPanel, BorderLayout.CENTER);
                        resultFrame.pack();
                        resultFrame.setVisible(true);

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
        frame.add(new JLabel("Age:"));
        frame.add(ageField);
        frame.add(validateButton);
        frame.pack();
        frame.setVisible(true);
    }
}