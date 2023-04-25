package view.history;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HistoryEntry extends JPanel {

    private JTextArea entrySentenceLabel = new JTextArea();
    private JTextArea entryResultLabel = new JTextArea();

    private String sentence = "Sentence";
    private String result = "Result";
    
    public HistoryEntry(String sentence, String result) {

        this.sentence = sentence;
        this.result = result;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addEntryInformation();

        setBorder(BorderFactory.createLineBorder(Color.black));
        setVisible(true);

    }

    private void addEntryInformation() {
        entrySentenceLabel.setEnabled(false);
        entrySentenceLabel.setDisabledTextColor(Color.BLACK);
        entrySentenceLabel.setOpaque(false);
        entrySentenceLabel.setLineWrap(true);
        entrySentenceLabel.setWrapStyleWord(true);
        entrySentenceLabel.setFont(new Font(getFont().getName(), getFont().getStyle(), getFont().getSize()+2));
        entrySentenceLabel.setText("Sentence: "+sentence);

        entryResultLabel.setEnabled(false);
        entryResultLabel.setDisabledTextColor(Color.BLACK);
        entryResultLabel.setOpaque(false);
        entryResultLabel.setLineWrap(true);
        entryResultLabel.setWrapStyleWord(true);
        entryResultLabel.setText("      Result: "+result);
        
        add(entrySentenceLabel);
        add(entryResultLabel);
    }

    public String getSentence() {
        return sentence;
    }

    public String getResult() {
        return result;
    }

}
