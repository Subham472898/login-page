import java.awt.*;
import javax.swing.*;

public class SecuredPage {
    public static void showSecuredPage(String username) {
        JFrame securedFrame = new JFrame("Secured Page");
        securedFrame.setSize(300, 150);
        securedFrame.setLayout(new BorderLayout());
        securedFrame.getContentPane().setBackground(Color.WHITE);
        securedFrame.setResizable(false);

        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!", JLabel.CENTER);
        welcomeLabel.setForeground(Color.BLACK);

        JButton logoutButton = new JButton("Logout");
        UIStyle.styleButton(logoutButton);
        logoutButton.addActionListener(e -> securedFrame.dispose());

        securedFrame.add(welcomeLabel, BorderLayout.CENTER);
        securedFrame.add(logoutButton, BorderLayout.SOUTH);

        securedFrame.setLocationRelativeTo(null);
        securedFrame.setVisible(true);
    }
}
