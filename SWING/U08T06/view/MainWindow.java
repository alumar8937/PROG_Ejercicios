package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import programLanguage.LangHandler;
import view.create.*;
import view.modify.PlayerModificationPanel;
import view.modify.TeamModificationPanel;
import view.query.PlayerQueryPanel;
import view.query.TeamQueryPanel;
import programLanguage.ProgramLanguage;

public class MainWindow extends JFrame {

    private static MainWindow INSTANCE = null;

    private static MainWindowContainerPanel mainWindowContainerPanel = null;
    
    private MainWindow () {
        mainWindowContainerPanel = new MainWindowContainerPanel();
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

    private static JPanel navigationButtonPanel = new JPanel();
    private static JPanel teamButtonPanel = new JPanel();
    private static JPanel playerButtonPanel = new JPanel();
    private static JPanel dataButtonPanel = new JPanel();

    private static JButton teamCreationPanelButton = new JButton();
    private static JButton playerCreationPanelButton = new JButton();

    private static JButton playerModificationPanelButton = new JButton();
    private static JButton teamModificationPanelButton = new JButton();

    private static JButton playerQueryPanelButton = new JButton();
    private static JButton teamQueryPanelButton = new JButton();

    private static JButton showDataButton = new JButton();
    private static JButton saveDataButton = new JButton();

    private static JLabel languageLabel = new JLabel();
    private static JComboBox<ProgramLanguage> changeLanguageComboBox = new JComboBox<ProgramLanguage>();

    private static JPanel programPanel = new JPanel();

    public MainWindowContainerPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        teamButtonPanel.setLayout(new BoxLayout(teamButtonPanel, BoxLayout.Y_AXIS));
        playerButtonPanel.setLayout(new BoxLayout(playerButtonPanel, BoxLayout.Y_AXIS));
        dataButtonPanel.setLayout(new BoxLayout(dataButtonPanel, BoxLayout.Y_AXIS));

        updateLang();

        teamCreationPanelButton.addActionListener((e) -> establishPanel(new TeamCreationPanel()));
        playerCreationPanelButton.addActionListener((e) -> establishPanel(new PlayerCreationPanel()));

        playerModificationPanelButton.addActionListener((e) -> establishPanel(new PlayerModificationPanel()));
        teamModificationPanelButton.addActionListener((e) -> establishPanel(new TeamModificationPanel()));

        playerQueryPanelButton.addActionListener((e) -> establishPanel(new PlayerQueryPanel()));
        teamQueryPanelButton.addActionListener((e) -> establishPanel(new TeamQueryPanel()));
        showDataButton.addActionListener((e) -> Controller.imprimirDatosPorConsola());
        saveDataButton.addActionListener((e) -> saveDataButtonAction());

        fillchangeLanguageComboBox();

        changeLanguageComboBox.addActionListener((e) -> changeLanguage());

        teamButtonPanel.add(teamCreationPanelButton);
        teamButtonPanel.add(teamModificationPanelButton);
        teamButtonPanel.add(teamQueryPanelButton);
        playerButtonPanel.add(playerCreationPanelButton);
        playerButtonPanel.add(playerModificationPanelButton);
        playerButtonPanel.add(playerQueryPanelButton);
        dataButtonPanel.add(showDataButton);
        dataButtonPanel.add(saveDataButton);
        dataButtonPanel.add(languageLabel);
        navigationButtonPanel.add(teamButtonPanel);
        navigationButtonPanel.add(playerButtonPanel);
        navigationButtonPanel.add(dataButtonPanel);
        navigationButtonPanel.add(changeLanguageComboBox);

        add(navigationButtonPanel);
        add(programPanel);
    }

    private void saveDataButtonAction() {
        try {
            Controller.saveData();
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("operacionCompletada"));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("error"));
            return;
        }
    }

    private void changeLanguage() {
        LangHandler.getInstance().load((ProgramLanguage) changeLanguageComboBox.getSelectedItem());
        updateLang();
        programPanel.removeAll();
        MainWindow.getInstance().pack();
    }

    private void updateLang() {
        playerCreationPanelButton.setText(LangHandler.getInstance().getProperty("crearJugador"));
        playerModificationPanelButton.setText(LangHandler.getInstance().getProperty("modificarJugador"));
        playerQueryPanelButton.setText(LangHandler.getInstance().getProperty("consultarJugador"));
        teamCreationPanelButton.setText(LangHandler.getInstance().getProperty("crearEquipo"));
        teamModificationPanelButton.setText(LangHandler.getInstance().getProperty("modificarEquipo"));
        teamQueryPanelButton.setText(LangHandler.getInstance().getProperty("consultarEquipo"));
        showDataButton.setText(LangHandler.getInstance().getProperty("mostrarDatos"));
        languageLabel.setText(LangHandler.getInstance().getProperty("idioma"));
        saveDataButton.setText(LangHandler.getInstance().getProperty("save"));
    }

    private void fillchangeLanguageComboBox() {
        for (ProgramLanguage l: ProgramLanguage.values()) {
            changeLanguageComboBox.addItem(l);
        }
    }

    public void establishPanel(JPanel panel) {
        programPanel.removeAll();
        programPanel.add(panel);
        MainWindow.getInstance().revalidate();
        MainWindow.getInstance().repaint();
        MainWindow.getInstance().pack();
    }

}