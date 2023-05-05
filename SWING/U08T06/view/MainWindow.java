package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import programLanguage.LangHandler;
import view.create.*;
import programLanguage.ProgramLanguage;

public class MainWindow extends JFrame {

    private static MainWindow INSTANCE = null;

    private static MainWindowContainerPanel mainWindowContainerPanel = null;
    
    private MainWindow () {
        mainWindowContainerPanel = MainWindowContainerPanel.getInstance();
        add(mainWindowContainerPanel);
        setSize(550, 500);
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
    private static JButton teamCreationPanelButton = new JButton();
    private static JButton playerCreationPanelButton = new JButton();
    private static JButton mostrarDatosButton = new JButton();
    private static JLabel idiomaLabel = new JLabel();
    private static JComboBox<ProgramLanguage> cambiarIdiomaComboBox = new JComboBox<ProgramLanguage>();

    private static JPanel programPanel = null;

    private MainWindowContainerPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        updateLang();
        
        playerCreationPanelButton.setBackground(Color.WHITE);
        teamCreationPanelButton.setBackground(Color.WHITE);
        playerCreationPanelButton.setFocusPainted(false);
        teamCreationPanelButton.setFocusPainted(false);

        teamCreationPanelButton.addActionListener((e) -> teamCreationPanelButtonAction());
        playerCreationPanelButton.addActionListener((e) -> playerCreationPanelButtonAction());
        mostrarDatosButton.addActionListener((e) -> Controller.imprimirDatosPorConsola());

        fillCambiarIdiomaComboBox();

        cambiarIdiomaComboBox.addActionListener((e) -> cambiarIdioma());

        navigationButtonPanel.add(teamCreationPanelButton);
        navigationButtonPanel.add(playerCreationPanelButton);
        navigationButtonPanel.add(mostrarDatosButton);
        navigationButtonPanel.add(idiomaLabel);
        navigationButtonPanel.add(cambiarIdiomaComboBox);

        programPanel = new JPanel();

        add(navigationButtonPanel);
        add(programPanel);

    }

    private void cambiarIdioma() {
        LangHandler.getInstance().load((ProgramLanguage) cambiarIdiomaComboBox.getSelectedItem());
        updateLang();
        PlayerCreationPanel.getInstance().updateLang();
        TeamCreationPanel.getInstance().updateLang();
    }

    private void updateLang() {
        teamCreationPanelButton.setText(LangHandler.getInstance().getProperty("crearEquipo"));
        playerCreationPanelButton.setText(LangHandler.getInstance().getProperty("crearJugador"));
        mostrarDatosButton.setText(LangHandler.getInstance().getProperty("mostrarDatos"));
        idiomaLabel.setText(LangHandler.getInstance().getProperty("idioma"));
    }

    private void fillCambiarIdiomaComboBox() {
        for (ProgramLanguage l: ProgramLanguage.values()) {
            cambiarIdiomaComboBox.addItem(l);
        }
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