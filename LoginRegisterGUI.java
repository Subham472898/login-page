import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class LoginRegisterGUI {
    private static HashMap<String, String> userDatabase = new HashMap<>();
    private static JFrame frame;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JLabel statusLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginRegisterGUI::createLoginUI);
    }

    private static void createLoginUI() {
        frame = new JFrame("Login System");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        userLabel.setForeground(Color.BLACK);
        passLabel.setForeground(Color.BLACK);

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        // Set full black border and padding for text fields
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        formPanel.add(userLabel);
        formPanel.add(usernameField);
        formPanel.add(passLabel);
        formPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        styleButton(loginButton);
        styleButton(registerButton);

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        statusLabel = new JLabel(" ", JLabel.CENTER);
        statusLabel.setForeground(Color.BLACK);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(statusLabel, BorderLayout.NORTH);

        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> register());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleButton(JButton button) {
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
    }

    private static void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            showSecuredPage(username);
        } else {
            statusLabel.setText("Invalid username or password.");
        }
    }

    private static void register() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (userDatabase.containsKey(username)) {
            statusLabel.setText("Username already exists.");
        } else if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Fields cannot be empty.");
        } else {
            userDatabase.put(username, password);
            statusLabel.setText("Registration successful!");
        }
    }

    private static void showSecuredPage(String username) {
        JFrame securedFrame = new JFrame("Secured Page");
        securedFrame.setSize(300, 150);
        securedFrame.setLayout(new BorderLayout());
        securedFrame.getContentPane().setBackground(Color.WHITE);
        securedFrame.setResizable(false);

        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!", JLabel.CENTER);
        welcomeLabel.setForeground(Color.BLACK);

        JButton logoutButton = new JButton("Logout");
        styleButton(logoutButton);
        logoutButton.addActionListener(e -> securedFrame.dispose());

        securedFrame.add(welcomeLabel, BorderLayout.CENTER);
        securedFrame.add(logoutButton, BorderLayout.SOUTH);

        securedFrame.setLocationRelativeTo(null);
        securedFrame.setVisible(true);
    }
}
