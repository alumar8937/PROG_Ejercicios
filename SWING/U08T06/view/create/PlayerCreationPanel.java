package view.create;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;
import model.PlayerPosition;
import model.Team;
import programLanguage.LangHandler;
import view.form.PlayerFormPanel;

public class PlayerCreationPanel extends JPanel {

    private static PlayerCreationPanel INSTANCE = null;

    private static Border border = BorderFactory.createLineBorder(Color.BLACK);

    private PlayerFormPanel form = new PlayerFormPanel();
    private JButton okButton = new JButton(); 
    
    private PlayerCreationPanel() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(border);
        
        okButton.addActionListener((e) -> createPlayer());

        updateLang();

        add(form);
        add(okButton);

    }

    private void createPlayer() {
        try {
            Object[] fields = form.getFields();
            Controller.addPlayer((Team) fields[0], (PlayerPosition) fields[1], (String) fields[2], (int) fields[3], (int) fields[4], (int) fields[5]);
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("operacionCompletada"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("error"));
        }
    }

    public void updateLang() {
        okButton.setText(LangHandler.getInstance().getProperty("ok"));
        form.updateLang();
    }

    public static PlayerCreationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerCreationPanel();
        }
        return INSTANCE;
    }

}
