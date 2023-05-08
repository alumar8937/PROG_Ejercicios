package view.create;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;
import programLanguage.LangHandler;
import view.form.TeamFormPanel;

public class TeamCreationPanel extends JPanel {

    private static TeamCreationPanel INSTANCE = null;

    private static Border border = BorderFactory.createLineBorder(Color.BLACK);

    private TeamFormPanel form = new TeamFormPanel();
    private JButton okButton = new JButton(); 
    
    private TeamCreationPanel() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(border);
        
        okButton.addActionListener((e) -> createTeam());

        updateLang();

        add(form);
        add(okButton);

    }

    private void createTeam() {
        try {
            Object[] fields = form.getFields();
            Controller.addTeam((String) fields[0], (String) fields[1], (String) fields[2], (String) fields[3]);
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("operacionCompletada"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("error"));
        }
    }

    public void updateLang() {
        okButton.setText(LangHandler.getInstance().getProperty("ok"));
        form.updateLang();
    }

    public static TeamCreationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TeamCreationPanel();
        }
        return INSTANCE;
    }

}
