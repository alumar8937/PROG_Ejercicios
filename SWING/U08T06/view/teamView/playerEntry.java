package view.teamView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class playerEntry extends JPanel {

    private String playerData = "";

    private JEditorPane playerDataLabel = new JEditorPane("text/html", "");

    private Font font = new Font(getFont().getName(), getFont().getStyle(), getFont().getSize()+1);
    private String cssStyle = "<head><style>b {font-size: 1.15em;font-style: italic;}</style></head>";
    
    public playerEntry(String playerData) {

        this.playerData = playerData;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addEntryInformation();

        setBorder(BorderFactory.createLineBorder(Color.black));
        setVisible(true);

    }

    private void addEntryInformation() {
        playerDataLabel.setEnabled(false);
        playerDataLabel.setOpaque(false);
        playerDataLabel.setDisabledTextColor(Color.BLACK);
        playerDataLabel.setFont(font);
        playerDataLabel.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
        playerDataLabel.setText("<html>"+cssStyle+playerData+"</html>");
        
        add(playerDataLabel);
    }

}
