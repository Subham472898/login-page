import java.awt.*;
import javax.swing.*;

public class UIStyle {
    public static void styleButton(JButton button) {
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
    }
}
