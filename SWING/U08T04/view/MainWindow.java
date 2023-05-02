package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import view.creation.PlayerCreationPanel;
import view.creation.TeamCreationPanel;

public class MainWindow extends JFrame {

    private static MainWindow INSTANCE = null;

    private static MainWindowContainerPanel mainWindowContainerPanel = null;
    
    private MainWindow () {
        mainWindowContainerPanel = MainWindowContainerPanel.getInstance();
        add(mainWindowContainerPanel);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

    private static JPanel navigationButtonPanel = new JPanel();
    private static JButton teamCreationPanelButton = new JButton("Team Creation");
    private static JButton playerCreationPanelButton = new JButton("Player Creation");
    private static JButton mostrarDatosButton = new JButton("Mostrar Datos");

    private static JPanel programPanel = null;

    private MainWindowContainerPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        playerCreationPanelButton.setBackground(Color.WHITE);
        teamCreationPanelButton.setBackground(Color.WHITE);
        playerCreationPanelButton.setFocusPainted(false);
        teamCreationPanelButton.setFocusPainted(false);

        teamCreationPanelButton.addActionListener((e) -> teamCreationPanelButtonAction());
        playerCreationPanelButton.addActionListener((e) -> playerCreationPanelButtonAction());
        mostrarDatosButton.addActionListener((e) -> Controller.imprimirDatosPorConsola());

        navigationButtonPanel.add(teamCreationPanelButton);
        navigationButtonPanel.add(playerCreationPanelButton);
        navigationButtonPanel.add(mostrarDatosButton);

        programPanel = new JPanel();

        add(navigationButtonPanel);
        add(programPanel);

    }

    private void playerCreationPanelButtonAction() {
        establishPanel(PlayerCreationPanel.getInstance());
        playerCreationPanelButton.setBackground(Color.GRAY);
        teamCreationPanelButton.setBackground(Color.WHITE);
    }

    private void teamCreationPanelButtonAction() {
        establishPanel(TeamCreationPanel.getInstance());
        teamCreationPanelButton.setBackground(Color.GRAY);
        playerCreationPanelButton.setBackground(Color.WHITE);
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