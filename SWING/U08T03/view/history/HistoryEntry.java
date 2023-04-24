package view.history;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoryEntry extends JPanel {

    private JPanel entryPanel = new JPanel();
    private JLabel entrySentenceLabel = new JLabel("Sentence");
    private JLabel entryResultLabel = new JLabel("Result");

    private String sentence = "Sentence";
    private String result = "Result";
    
    public HistoryEntry(String sentence, String result) {

        entrySentenceLabel.setText("Sentence: "+sentence);
        entryResultLabel.setText("      Result: "+result);

        entryPanel.setLayout(new BoxLayout(entryPanel, BoxLayout.Y_AXIS));
        entryPanel.add(entrySentenceLabel);
        entryPanel.add(entryResultLabel);

        add(entryPanel);
        
        setBorder(BorderFactory.createLineBorder(Color.black));
        setVisible(true);

    }

    public String getSentence() {
        return sentence;
    }

    public String getResult() {
        return result;
    }

}
