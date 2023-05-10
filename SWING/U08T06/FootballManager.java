import view.FrameUtils;
import view.MainWindow;

public class FootballManager {
    public static void main(String[] args) {
        MainWindow mainWindow = MainWindow.getInstance();
        FrameUtils.centerWindowOnScreen(mainWindow);
        mainWindow.setVisible(true);
        System.out.println("Ronaldiño Soccer! HAHAHA.");
    }
}
