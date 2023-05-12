import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import programLanguage.LangHandler;
import view.FrameUtils;
import view.MainWindow;

public class FootballManager {
    public static void main(String[] args) {
        loadData();
        MainWindow mainWindow = MainWindow.getInstance();
        FrameUtils.centerWindowOnScreen(mainWindow);
        mainWindow.setVisible(true);
    }

    private static void loadData() {
        try {
            Controller.loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(), LangHandler.getInstance().getProperty("errorData"));
            e.printStackTrace();
        }
    }

}
