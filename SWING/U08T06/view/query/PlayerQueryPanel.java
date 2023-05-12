package view.query;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;
import model.Player;
import model.Team;
import view.form.PlayerFormPanel;

public class PlayerQueryPanel extends JPanel {

    private static Border border = BorderFactory.createLineBorder(Color.BLACK);
    private JComboBox<Team> equipoComboBox = new JComboBox<Team>();
    private JComboBox<Player> playerComboBox = new JComboBox<Player>();
    private PlayerFormPanel form = new PlayerFormPanel();
    
    public PlayerQueryPanel() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(border);

        fillEquipoComboBox();

        updateLang();

        form.setFieldEnabled(false);
        equipoComboBox.addActionListener((e) -> {fillPlayerComboBox(); fillEquipoComboBox(); repaint();});
        playerComboBox.addActionListener((e) -> form.setFields((Player) playerComboBox.getSelectedItem(), (Team) equipoComboBox.getSelectedItem()));

        add(equipoComboBox);
        add(playerComboBox);
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

    private void fillPlayerComboBox() {
        playerComboBox.removeAllItems();
        for (Player p: ((Team) equipoComboBox.getSelectedItem()).getPlayers()) {
            playerComboBox.addItem(p);
        }
    }

}
