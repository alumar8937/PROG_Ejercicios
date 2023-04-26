package view.history;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

import config.Constants;

public class HistoryEntry extends JPanel {

    private JEditorPane entrySentenceLabel = new JEditorPane("text/html", "");
    private JEditorPane entryResultLabel = new JEditorPane("text/html", "");

    private String sentence = "Sentence";
    private double result = 0;
    private boolean wasSyntaxError = false;

    private Font font = new Font(getFont().getName(), getFont().getStyle(), getFont().getSize()+1);
    private String cssStyle = "<head><style>b {font-size: 1.15em;font-style: italic;}</style></head>";
    
    public HistoryEntry(String sentence, double result, boolean wasSyntaxError) {

        this.sentence = sentence;
        this.result = result;
        this.wasSyntaxError = wasSyntaxError;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addEntryInformation();

        setBorder(BorderFactory.createLineBorder(Color.black));
        setVisible(true);

    }

    private void addEntryInformation() {
        entrySentenceLabel.setEnabled(false);
        entrySentenceLabel.setOpaque(false);
        entrySentenceLabel.setDisabledTextColor(Color.BLACK);
        entrySentenceLabel.setFont(font);
        entrySentenceLabel.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
        entrySentenceLabel.setText("<html>"+cssStyle+"<b>Sentence:</b> "+sentence+"</html>");

        entryResultLabel.setEnabled(false);
        entryResultLabel.setOpaque(false);
        entryResultLabel.setDisabledTextColor(Color.BLACK);
        entryResultLabel.setFont(font);
        entryResultLabel.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
        entryResultLabel.setText("<html>"+cssStyle+"      <b>Result:</b> "+getDisplayResult()+"</html>");
        
        add(entrySentenceLabel);
        add(entryResultLabel);
    }

    public String getDisplayResult() {
        if (!wasSyntaxError) {
            return Constants.SYNTAX_ERROR;
        }
        return result+"";
    }

}
