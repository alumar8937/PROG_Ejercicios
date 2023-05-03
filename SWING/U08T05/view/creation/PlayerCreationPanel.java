package view.creation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controller;
import model.Demarcacion;
import model.Equipo;
import programLanguage.ProgramLanguageProperties;

public class PlayerCreationPanel extends JPanel {
    
    private static PlayerCreationPanel INSTANCE = null;
    private static Border border = BorderFactory.createLineBorder(Color.BLACK);

    private JComboBox<Equipo> equipoComboBox = new JComboBox<Equipo>();
    private JComboBox<Demarcacion> demarcacionComboBox = new JComboBox<Demarcacion>();
    private JTextField nombre = new JTextField();
    private JTextField anyoNacimiento = new JTextField();
    private JTextField altura = new JTextField();
    private JTextField dorsal = new JTextField();
    private JButton botonAnyadir = new JButton("Añadir Jugador");

    private JLabel equipoLabel = new JLabel("Equipo:");
    private JLabel demarcacionLabel = new JLabel("Demarcación:");
    private JLabel nombreLabel = new JLabel("Nombre:");
    private JLabel anyoNacimientoLabel = new JLabel("Año de nacimiento:");
    private JLabel alturaLabel = new JLabel("Altura:");
    private JLabel dorsalLabel = new JLabel("Dorsal:");


    private PlayerCreationPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(550,400));
        setBorder(border);
        
        fillEquipoComboBox();
        fillDemarcacionComboBox();
        botonAnyadir.addActionListener((e) -> anyadirJugador());

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
        add(botonAnyadir);
    }

    private void anyadirJugador() {
        try {
            Controller.addJugador((Equipo) equipoComboBox.getSelectedItem(), (Demarcacion) demarcacionComboBox.getSelectedItem(), nombre.getText(), Integer.parseInt(anyoNacimiento.getText()), Integer.parseInt(altura.getText()), Integer.parseInt(dorsal.getText()));
            JOptionPane.showMessageDialog(this, "Jugador añadido correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al añadir el jugador, intentalo de nuevo.");
            e.printStackTrace();
        }
    }

    public void updateLang() {
        botonAnyadir.setText(ProgramLanguageProperties.getInstance().getProperty("anyadirJugador"));
        equipoLabel.setText(ProgramLanguageProperties.getInstance().getProperty("equipo"));
        demarcacionLabel.setText(ProgramLanguageProperties.getInstance().getProperty("demarcacion"));
        nombreLabel.setText(ProgramLanguageProperties.getInstance().getProperty("nombre"));
        anyoNacimientoLabel.setText(ProgramLanguageProperties.getInstance().getProperty("anyoNacimiento"));
        alturaLabel.setText(ProgramLanguageProperties.getInstance().getProperty("altura"));
        dorsalLabel.setText(ProgramLanguageProperties.getInstance().getProperty("dorsal"));
        repaint();
    }

    private void fillEquipoComboBox() {
        equipoComboBox.removeAllItems();
        for (Equipo e: Controller.getEquipos()) {
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
        for (Demarcacion d: Controller.getDemarcaciones()) {
            demarcacionComboBox.addItem(d);
        }
    }

    public static PlayerCreationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerCreationPanel();
        }
        return INSTANCE;
    }

}
