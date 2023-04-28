package view.creation;

import java.awt.Color;
import javax.swing.JPanel;

public class PlayerCreationPanel extends JPanel {
    
    private static PlayerCreationPanel INSTANCE = null;

    private PlayerCreationPanel() {
        setPreferredSize(new Dimension(300,300));
        setBackground(Color.RED);
    }

    public static PlayerCreationPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerCreationPanel();
        }
        return INSTANCE;
    }

}
