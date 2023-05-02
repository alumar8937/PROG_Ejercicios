package view.creation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controller;

public class TeamCreationPanel extends JPanel {

    private static TeamCreationPanel INSTANCE = null;
    private static Border border = BorderFactory.createLineBorder(Color.BLACK);

    private JTextField nombre = new JTextField();
    private JTextField pais = new JTextField();
    private JTextField nombreCompeticion = new JTextField();
    private JTextField nombreEntrenador = new JTextField();

    private JButton botonAnyadir = new JButton("Añadir equipo");

    private TeamCreationPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(500,400));
        setBorder(border);

        botonAnyadir.addActionListener((e) -> anyadirEquipo());

        add(new JLabel("Nombre:"));
        add(nombre);
        add(new JLabel("País:"));
        add(pais);
        add(new JLabel("Nombre de la competición:"));
        add(nombreCompeticion);
        add(new JLabel("Nombre del entrenador:"));
        add(nombreEntrenador);
        add(botonAnyadir);
        //String nombre, String pais, String nombreCompeticion, String nombreEntrenador
    }

    private void anyadirEquipo() {
        try {
            Controller.addEquipo(nombre.getText(), pais.getText(), nombreCompeticion.getText(), nombreEntrenador.getText());
            JOptionPane.showMessageDialog(this, "Equipo añadido correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al añadir el equipo, intentalo de nuevo.");
        }
    }

    public static TeamCreationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TeamCreationPanel();
        }
        return INSTANCE;
    }

}
