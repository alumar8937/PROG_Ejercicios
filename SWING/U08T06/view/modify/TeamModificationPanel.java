package view.modify;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;
import model.Team;
import programLanguage.LangHandler;
import view.form.TeamFormPanel;

public class TeamModificationPanel extends JPanel {

    private static TeamModificationPanel INSTANCE = null;

    private Team equipo = null;

    private Border border = BorderFactory.createLineBorder(Color.BLACK);
    private JComboBox<Team> equipoComboBox = new JComboBox<Team>();

    private TeamFormPanel form = new TeamFormPanel();
    private JButton okButton = new JButton(); 
    
    private TeamModificationPanel() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(border);
        
        equipoComboBox.addActionListener((e) -> {equipo = (Team) equipoComboBox.getSelectedItem(); fillFields(); fillEquipoComboBox(); repaint();});
        fillEquipoComboBox();

        okButton.addActionListener((e) -> modifyTeam(equipo));

        updateLang();

        add(equipoComboBox);
        add(form);
        add(okButton);

    }

    private void fillFields() {
        form.setFields(new Object[]{equipo.getName(), equipo.getCountry(), equipo.getCompetitionName(), equipo.getCoachName()});
    }

    private void modifyTeam(Team equipo) {
        try {
            Object[] fields = form.getFields();
            Controller.modifyTeam(equipo, (String) fields[0], (String) fields[1], (String) fields[2], (String) fields[3]);
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("operacionCompletada"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("error"));
        }
    }

    private void fillEquipoComboBox() {
        equipoComboBox.removeAllItems();
        for (Team e: Controller.getTeams()) {
            equipoComboBox.addItem(e);
        }
    }

    public void updateLang() {
        okButton.setText(LangHandler.getInstance().getProperty("ok"));
        form.updateLang();
    }

    public static TeamModificationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TeamModificationPanel();
        }
        return INSTANCE;
    }

}
