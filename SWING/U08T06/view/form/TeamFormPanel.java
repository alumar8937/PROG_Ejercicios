package view.form;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Team;
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

        nombre.setDisabledTextColor(Color.BLACK);
        pais.setDisabledTextColor(Color.BLACK);
        nombreCompeticion.setDisabledTextColor(Color.BLACK);
        nombreEntrenador.setDisabledTextColor(Color.BLACK);

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

    public void setFields(Team team) {
        if (team == null) {
            return;
        }
        nombre.setText(team.getName());
        pais.setText(team.getCountry());
        nombreCompeticion.setText(team.getCompetitionName());
        nombreEntrenador.setText(team.getCoachName());
    }

    public void setFieldEnabled(boolean enabled) {
        nombre.setEnabled(enabled);
        pais.setEnabled(enabled);
        nombreCompeticion.setEnabled(enabled);
        nombreEntrenador.setEnabled(enabled);
    }
    public void setFields(Object[] fields) {
        nombre.setText((String) fields[0]);
        pais.setText((String) fields[1]);
        nombreCompeticion.setText((String) fields[2]);
        nombreEntrenador.setText((String) fields[3]);
    }

}
