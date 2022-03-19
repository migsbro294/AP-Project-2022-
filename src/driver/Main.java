package driver;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import jdbc.controllers.CustomerPassword;
import mdi.Parent;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        CustomerPassword customerPassword=new CustomerPassword();
        customerPassword.createPassword("9987","kamoy");
    }
}

