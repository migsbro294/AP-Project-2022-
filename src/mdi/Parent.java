package mdi;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class Parent extends JFrame{
    private final JDesktopPane deskPane = new JDesktopPane();

    public Parent(String title){
        super(title);
        //Just for testing
        JInternalFrame testFrame = new JInternalFrame("Test Frame", true,true, true, true);
        JLabel label1 = new JLabel("Test\nTest");
        testFrame.getContentPane().add(label1);
        testFrame.pack();
        testFrame.setVisible(true);
        deskPane.add(testFrame);

        
        this.add(deskPane, BorderLayout.CENTER);


        this.setMinimumSize(new Dimension(300, 300));
    }
}
