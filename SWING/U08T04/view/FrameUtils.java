package view;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class FrameUtils {

    private static Toolkit toolkit = Toolkit.getDefaultToolkit();

    public static void centerWindowOnScreen(JFrame window) {
        window.setLocation((int) toolkit.getScreenSize().getWidth()/2-window.getWidth()/2,
                        (int) toolkit.getScreenSize().getHeight()/2-window.getHeight()/2 );
    }

}
