package view.form;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Equipo;
import programLanguage.LangHandler;

public class TeamFormPanel extends JPanel {

    private JTextField nombre = new JTextField();
    private JTextField pais = new JTextField();
    private JTextField nombreCompeticion = new JTextField();
    private JTextField nombreEntrenador = new JTextField();

    private JLabel nombreLabel = new JLabel();
    private JLabel paisLabel = new JLabel();
    private JLabel nombreCompeticionLabel = new JLabel();
    private JLabel nombreEntrenadorLabel = new JLabel();

    public TeamFormPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(550,400));

        updateLang();

        add(nombreLabel);
        add(nombre);
        add(paisLabel);
        add(pais);
        add(nombreCompeticionLabel);
        add(nombreCompeticion);
        add(nombreEntrenadorLabel);
        add(nombreEntrenador);
    }

    public void updateLang() {
        nombreLabel.setText(LangHandler.getInstance().getProperty("nombre"));
        paisLabel.setText(LangHandler.getInstance().getProperty("pais"));
        nombreCompeticionLabel.setText(LangHandler.getInstance().getProperty("competicion"));
        nombreEntrenadorLabel.setText(LangHandler.getInstance().getProperty("entrenador"));
        repaint();
    }

    public Object[] getFields() {
        return new Object[]{nombre.getText(), pais.getText(), nombreCompeticion.getText(), nombreEntrenador.getText()};
    }

<<<<<<< HEAD
    public void setFields(Equipo equipo) {
        nombre.setText(equipo.getNombre());
        pais.setText(equipo.getPais());
        nombreCompeticion.setText(equipo.getNombreCompeticion());
        nombreEntrenador.setText(equipo.getNombreEntrenador());
    }

    public void setFieldEnabled(boolean enabled) {
        nombre.setEnabled(enabled);
        pais.setEnabled(enabled);
        nombreCompeticion.setEnabled(enabled);
        nombreEntrenador.setEnabled(enabled);
=======
    public void setFields(Object[] fields) {
        nombre.setText((String) fields[0]);
        pais.setText((String) fields[1]);
        nombreCompeticion.setText((String) fields[2]);
        nombreEntrenador.setText((String) fields[3]);
>>>>>>> 5e6fa6f03af0d597a7185e71e682a2311ca887b9
    }

}
