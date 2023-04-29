package view.creation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TeamCreationPanel extends JPanel {

    private static TeamCreationPanel INSTANCE = null;
    private static Border border = BorderFactory.createLineBorder(Color.BLACK);

    private TeamCreationPanel() {
        setPreferredSize(new Dimension(500,400));
        setBorder(border);
        add(new JLabel("Team Creation"));
    }

    public static TeamCreationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TeamCreationPanel();
        }
        return INSTANCE;
    }

}
