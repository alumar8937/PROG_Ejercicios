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
import footballLang.LangProperties;

public class TeamCreationPanel extends JPanel {

    private static TeamCreationPanel INSTANCE = null;
    private static Border border = BorderFactory.createLineBorder(Color.BLACK);

    private JTextField nombre = new JTextField();
    private JTextField pais = new JTextField();
    private JTextField nombreCompeticion = new JTextField();
    private JTextField nombreEntrenador = new JTextField();

    private JLabel nombreLabel = new JLabel();
    private JLabel paisLabel = new JLabel();
    private JLabel nombreCompeticionLabel = new JLabel();
    private JLabel nombreEntrenadorLabel = new JLabel();

    private JButton botonAnyadir = new JButton();

    private TeamCreationPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(550,400));
        setBorder(border);

        botonAnyadir.addActionListener((e) -> anyadirEquipo());

        updateLang();

        add(nombreLabel);
        add(nombre);
        add(paisLabel);
        add(pais);
        add(nombreCompeticionLabel);
        add(nombreCompeticion);
        add(nombreEntrenadorLabel);
        add(nombreEntrenador);
        add(botonAnyadir);
        //String nombre, String pais, String nombreCompeticion, String nombreEntrenador
    }

    public void updateLang() {
        botonAnyadir.setText(LangProperties.getInstance().getProperty("anyadirEquipo"));
        nombreLabel.setText(LangProperties.getInstance().getProperty("nombre"));
        paisLabel.setText(LangProperties.getInstance().getProperty("pais"));
        nombreCompeticionLabel.setText(LangProperties.getInstance().getProperty("competicion"));
        nombreEntrenadorLabel.setText(LangProperties.getInstance().getProperty("entrenador"));
        repaint();
    }

    private void anyadirEquipo() {
        try {
            Controller.addEquipo(nombre.getText(), pais.getText(), nombreCompeticion.getText(), nombreEntrenador.getText());
            PlayerCreationPanel.getInstance().repaint();
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
