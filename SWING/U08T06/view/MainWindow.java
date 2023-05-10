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
import view.modify.TeamModificationPanel;
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
        pack();
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
    private static JButton teamModificationPanelButton = new JButton();
    private static JButton showDataButton = new JButton();
    private static JLabel languageLabel = new JLabel();
    private static JComboBox<ProgramLanguage> changeLanguageComboBox = new JComboBox<ProgramLanguage>();

    private static JPanel programPanel = null;

    private MainWindowContainerPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        updateLang();
        
        playerCreationPanelButton.setBackground(Color.WHITE);
        teamCreationPanelButton.setBackground(Color.WHITE);
        teamModificationPanelButton.setBackground(Color.WHITE);
        playerCreationPanelButton.setFocusPainted(false);
        teamCreationPanelButton.setFocusPainted(false);
        teamModificationPanelButton.setFocusPainted(false);

        teamCreationPanelButton.addActionListener((e) -> teamCreationPanelButtonAction());
        playerCreationPanelButton.addActionListener((e) -> playerCreationPanelButtonAction());
        teamModificationPanelButton.addActionListener((e) -> teamModificationPanelButtonAction());
        showDataButton.addActionListener((e) -> Controller.imprimirDatosPorConsola());

        fillchangeLanguageComboBox();

        changeLanguageComboBox.addActionListener((e) -> changeLanguage());

        navigationButtonPanel.add(teamCreationPanelButton);
        navigationButtonPanel.add(playerCreationPanelButton);
        navigationButtonPanel.add(teamModificationPanelButton);
        navigationButtonPanel.add(showDataButton);
        navigationButtonPanel.add(languageLabel);
        navigationButtonPanel.add(changeLanguageComboBox);

        programPanel = new JPanel();

        add(navigationButtonPanel);
        add(programPanel);
    }

    private void changeLanguage() {
        LangHandler.getInstance().load((ProgramLanguage) changeLanguageComboBox.getSelectedItem());
        updateLang();
        PlayerCreationPanel.getInstance().updateLang();
        TeamCreationPanel.getInstance().updateLang();
        MainWindow.getInstance().pack();
    }

    private void updateLang() {
        teamCreationPanelButton.setText(LangHandler.getInstance().getProperty("crearEquipo"));
        playerCreationPanelButton.setText(LangHandler.getInstance().getProperty("crearJugador"));
        teamModificationPanelButton.setText(LangHandler.getInstance().getProperty("modificarEquipo"));
        showDataButton.setText(LangHandler.getInstance().getProperty("mostrarDatos"));
        languageLabel.setText(LangHandler.getInstance().getProperty("idioma"));
    }

    private void fillchangeLanguageComboBox() {
        for (ProgramLanguage l: ProgramLanguage.values()) {
            changeLanguageComboBox.addItem(l);
        }
    }

    private void playerCreationPanelButtonAction() {
        establishPanel(PlayerCreationPanel.getInstance());
        playerCreationPanelButton.setBackground(Color.GRAY);
        teamCreationPanelButton.setBackground(Color.WHITE);
        teamModificationPanelButton.setBackground(Color.WHITE);
    }

    private void teamCreationPanelButtonAction() {
        establishPanel(TeamCreationPanel.getInstance());
        teamCreationPanelButton.setBackground(Color.GRAY);
        playerCreationPanelButton.setBackground(Color.WHITE);
        teamModificationPanelButton.setBackground(Color.WHITE);
    }

    private void teamModificationPanelButtonAction() {
        establishPanel(TeamModificationPanel.getInstance());
        teamCreationPanelButton.setBackground(Color.WHITE);
        playerCreationPanelButton.setBackground(Color.WHITE);
        teamModificationPanelButton.setBackground(Color.GRAY);
    }

    public static MainWindowContainerPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainWindowContainerPanel();
        }
        return INSTANCE;
    }

    public void establishPanel(JPanel panel) {
        programPanel.removeAll();
        programPanel.add(panel);
        MainWindow.getInstance().revalidate();
        MainWindow.getInstance().repaint();
        MainWindow.getInstance().pack();
    }

}