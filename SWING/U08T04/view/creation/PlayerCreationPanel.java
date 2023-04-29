package view.creation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PlayerCreationPanel extends JPanel {
    
    private static PlayerCreationPanel INSTANCE = null;
    private static Border border = BorderFactory.createLineBorder(Color.BLACK);

    private PlayerCreationPanel() {
        setPreferredSize(new Dimension(500,400));
        setBorder(border);
        add(new JLabel("Player Creation"));
    }

    public static PlayerCreationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerCreationPanel();
        }
        return INSTANCE;
    }

}
