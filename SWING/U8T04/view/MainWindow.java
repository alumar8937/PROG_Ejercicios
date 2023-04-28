package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.creation.PlayerCreationPanel;
import view.creation.TeamCreationPanel;

public class MainWindow extends JFrame {

    private static MainWindow INSTANCE = null;

    private static MainWindowContainerPanel mainWindowContainerPanel = null;
    
    private MainWindow () {
        mainWindowContainerPanel = MainWindowContainerPanel.getInstance();
        add(mainWindowContainerPanel);
        setSize(500, 500);
        setVisible(true);
    }

    public static MainWindow getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainWindow();
        }
        return INSTANCE;
    }

}

class MainWindowContainerPanel extends JPanel {

    private static MainWindowContainerPanel INSTANCE = null;

    private static JPanel navigationButtonPanel = null;
    private static JButton teamCreationPanelButton = null;
    private static JButton playerCreationPanelButton = null;

    private static JPanel programPanel = null;

    private MainWindowContainerPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        navigationButtonPanel = new JPanel();
        teamCreationPanelButton = new JButton("Team Creation");
        playerCreationPanelButton = new JButton("Player Creation");

        teamCreationPanelButton.addActionListener((e) -> establishPanel(PlayerCreationPanel.getInstance()));
        playerCreationPanelButton.addActionListener((e) -> establishPanel(TeamCreationPanel.getInstance()));

        navigationButtonPanel.add(teamCreationPanelButton);
        navigationButtonPanel.add(playerCreationPanelButton);

        programPanel = new JPanel();

        add(navigationButtonPanel);
        add(programPanel);
    }

    public static MainWindowContainerPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainWindowContainerPanel();
        }
        return INSTANCE;
    }

    public static void establishPanel(JPanel panel) {
        programPanel.removeAll();
        programPanel.add(panel);
        MainWindow.getInstance().revalidate();
        MainWindow.getInstance().repaint();
    }

}