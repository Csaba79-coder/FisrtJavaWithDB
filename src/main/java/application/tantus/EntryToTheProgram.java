package application.tantus;

import javax.swing.*;

public class EntryToTheProgram {

    String username;
    String password;
    String welcomeMessage = "Welcome " + System.getenv("DATABASE_USER") + "!";
    String rejectMessage = "Wrong input!";
    int tries = 3;
    int triesLeft = 3;
    boolean quit = false;

    private boolean verifyUsernameAndPassword() {

        // TODO hide password during typing!
        
        username = JOptionPane.showInputDialog("Username: ");
        password = JOptionPane.showInputDialog("Password: ");
        tries--;
        System.out.println("You have: " + --triesLeft + " more left!") ;
        if (username != null && password != null) {
            if (username.equals(System.getenv("DATABASE_USER")) &&
                    password.equals(System.getenv("DATABASE_USER"))) {
                JOptionPane.showMessageDialog(null, welcomeMessage);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, rejectMessage);
        return false;
    }

    public void enterTheProgram() {
        while (!verifyUsernameAndPassword() && tries > 0) {
            verifyUsernameAndPassword();
        }
    }
}
