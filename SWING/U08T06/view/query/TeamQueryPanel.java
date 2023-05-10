package view.query;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Equipo;
import view.form.TeamFormPanel;

public class TeamQueryPanel extends JPanel {

    private static TeamQueryPanel INSTANCE = null;

    private static Border border = BorderFactory.createLineBorder(Color.BLACK);
    private JComboBox<Equipo> equipoComboBox = new JComboBox<Equipo>();
    private TeamFormPanel form = new TeamFormPanel();
    
    private TeamQueryPanel() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(border);

        updateLang();

        form.setFieldEnabled(false);
        equipoComboBox.addActionListener((e) -> form.setFields((Equipo) equipoComboBox.getSelectedItem()));

        add(equipoComboBox);
        add(form);

    }

    public void updateLang() {
        form.updateLang();
    }

    public static TeamQueryPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TeamQueryPanel();
        }
        return INSTANCE;
    }

}
