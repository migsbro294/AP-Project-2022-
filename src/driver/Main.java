package driver;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import mdi.Parent;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Set the system look and feel
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            Parent frame = new Parent("MDI Frame");
            frame.pack();
            frame.setVisible(true);
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        });
    }
}

