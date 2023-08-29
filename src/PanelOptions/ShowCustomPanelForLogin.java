package PanelOptions;

import javax.swing.*;

public class ShowCustomPanelForLogin {
    public static void main(String[] args) {
        JOptionPane PanelForLogin = new JOptionPane();
    }
    public static boolean PanelForLogin() {
        String[] options = {"Ok", "No, voy a registrarme"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "¿Seguro que ya te has registrado?, si es así continua",
                "Ir a iniciar sesión",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );
        return choice == 0;
    }
}
