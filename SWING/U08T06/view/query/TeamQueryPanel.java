package view.query;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;
import model.Team;
import view.form.TeamFormPanel;

public class TeamQueryPanel extends JPanel {

    private static TeamQueryPanel INSTANCE = null;

    private static Border border = BorderFactory.createLineBorder(Color.BLACK);
    private JComboBox<Team> equipoComboBox = new JComboBox<Team>();
    private TeamFormPanel form = new TeamFormPanel();
    
    private TeamQueryPanel() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(border);

        fillEquipoComboBox();

        updateLang();

        form.setFieldEnabled(false);
        equipoComboBox.addActionListener((e) -> {form.setFields((Team) equipoComboBox.getSelectedItem()); fillEquipoComboBox(); repaint();});

        add(equipoComboBox);
        add(form);

    }

    public void updateLang() {
        form.updateLang();
    }

    private void fillEquipoComboBox() {
        equipoComboBox.removeAllItems();
        for (Team e: Controller.getTeams()) {
            equipoComboBox.addItem(e);
        }
    }

    public static TeamQueryPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TeamQueryPanel();
        }
        return INSTANCE;
    }

}
