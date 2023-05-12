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
import model.Player;
import model.PlayerPosition;
import model.Team;
import programLanguage.LangHandler;
import view.form.PlayerFormPanel;

public class PlayerModificationPanel extends JPanel {

    private static Border border = BorderFactory.createLineBorder(Color.BLACK);
    private JComboBox<Team> equipoComboBox = new JComboBox<Team>();
    private JComboBox<Player> playerComboBox = new JComboBox<Player>();
    private PlayerFormPanel form = new PlayerFormPanel();

    private JButton okButton = new JButton(); 
    private JButton delButton = new JButton();
    
    public PlayerModificationPanel() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(border);

        fillEquipoComboBox();

        updateLang();

        equipoComboBox.addActionListener((e) -> {fillPlayerComboBox(); fillEquipoComboBox(); repaint();});
        playerComboBox.addActionListener((e) -> form.setFields((Player) playerComboBox.getSelectedItem(), (Team) equipoComboBox.getSelectedItem()));

        delButton.addActionListener((e) -> {delButtonAction();});
        okButton.addActionListener((e) -> {okButtonAction();});

        add(equipoComboBox);
        add(playerComboBox);
        add(form);
        add(okButton);
        add(delButton);

    }

    private void delButtonAction() {
        ((Team) equipoComboBox.getSelectedItem()).getPlayers().remove((Player) playerComboBox.getSelectedItem());
        JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("operacionCompletada"));
    }

    private void okButtonAction() {
        try {
            Object[] fields = form.getFields();
            Player currentPlayer = (Player) playerComboBox.getSelectedItem();
            currentPlayer.setName((String) fields[2]);
            currentPlayer.setPlayerPosition((PlayerPosition) fields[1]);
            currentPlayer.setBirthyear((int) fields[3]);
            currentPlayer.setHeight((int) fields[4]);
            currentPlayer.setNumber((int) fields[5]);
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("operacionCompletada"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, LangHandler.getInstance().getProperty("error"));
            return;
        }
    }

    public void updateLang() {
        okButton.setText(LangHandler.getInstance().getProperty("ok"));
        delButton.setText(LangHandler.getInstance().getProperty("del"));
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
