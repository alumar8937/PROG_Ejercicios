package view.creation;

import java.awt.Color;

import javax.swing.JPanel;

public class TeamCreationPanel extends JPanel {

    private static TeamCreationPanel INSTANCE = null;

    private TeamCreationPanel() {
        setBackground(Color.BLUE);

    }

    public static TeamCreationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TeamCreationPanel();
        }
        return INSTANCE;
    }

}
