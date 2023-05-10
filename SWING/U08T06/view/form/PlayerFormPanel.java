package view.form;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.PlayerPosition;
import model.Team;
import programLanguage.LangHandler;

public class PlayerFormPanel extends JPanel {

    private JComboBox<Team> equipoComboBox = new JComboBox<Team>();
    private JComboBox<PlayerPosition> demarcacionComboBox = new JComboBox<PlayerPosition>();
    private JTextField nombre = new JTextField();
    private JTextField anyoNacimiento = new JTextField();
    private JTextField altura = new JTextField();
    private JTextField dorsal = new JTextField();

    private JLabel equipoLabel = new JLabel();
    private JLabel demarcacionLabel = new JLabel();
    private JLabel nombreLabel = new JLabel();
    private JLabel anyoNacimientoLabel = new JLabel();
    private JLabel alturaLabel = new JLabel();
    private JLabel dorsalLabel = new JLabel();


    public PlayerFormPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(550,400));
        
        fillEquipoComboBox();
        fillDemarcacionComboBox();

        updateLang();

        add(equipoLabel);
        add(equipoComboBox);

        add(demarcacionLabel);
    
        add(demarcacionComboBox);
        add(nombreLabel);
        add(nombre);
        add(anyoNacimientoLabel);
        add(anyoNacimiento);
        add(alturaLabel);
        add(altura);
        add(dorsalLabel);
        add(dorsal);
    }

    public Object[] getFields() throws Exception {
        return new Object[]{(Team) equipoComboBox.getSelectedItem(),(PlayerPosition) demarcacionComboBox.getSelectedItem(), nombre.getText(), Integer.parseInt(anyoNacimiento.getText()), Integer.parseInt(altura.getText()), Integer.parseInt(dorsal.getText())};
    }

    public void updateLang() {
        equipoLabel.setText(LangHandler.getInstance().getProperty("equipo"));
        demarcacionLabel.setText(LangHandler.getInstance().getProperty("demarcacion"));
        nombreLabel.setText(LangHandler.getInstance().getProperty("nombre"));
        anyoNacimientoLabel.setText(LangHandler.getInstance().getProperty("anyoNacimiento"));
        alturaLabel.setText(LangHandler.getInstance().getProperty("altura"));
        dorsalLabel.setText(LangHandler.getInstance().getProperty("dorsal"));
        repaint();
    }

    private void fillEquipoComboBox() {
        equipoComboBox.removeAllItems();
        for (Team e: Controller.getTeams()) {
            equipoComboBox.addItem(e);
        }
    }

    @Override
    public void repaint() {
        if (equipoComboBox != null) {
            fillEquipoComboBox();
            revalidate();
        }
        super.repaint();
    }

    private void fillDemarcacionComboBox() {
        for (PlayerPosition d: Controller.getPlayerPosition()) {
            demarcacionComboBox.addItem(d);
        }
    }

}
