package view.history;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import config.Constants;
import controller.RPNCalculatorController;

public class HistoryWindow extends JFrame {

    private static HistoryWindow INSTANCE = null;
    
    private JPanel historyWindowPanel = new JPanel();

    private Queue<HistoryEntry> historyEntryQueue = new LinkedList<HistoryEntry>();
    private HistoryEntryPanel historyEntryPanel = new HistoryEntryPanel();
    private JScrollPane historyEntryScrollPane = new JScrollPane(historyEntryPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    public HistoryWindow() {

        setSize(300, 500);
        setTitle(Constants.HISTORY_TITLE);

        historyEntryScrollPane.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        historyWindowPanel.setLayout(new BoxLayout(historyWindowPanel, BoxLayout.Y_AXIS));
        historyWindowPanel.add(historyEntryScrollPane);
        add(historyWindowPanel);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        repaint();
    }

    public static HistoryWindow getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HistoryWindow();
        }
        return INSTANCE;
    }

    @Override
    public void repaint() {
        // Add elements.
        historyEntryQueue = RPNCalculatorController.getResultHistory();
        historyEntryPanel.removeAll();
        for (HistoryEntry h: historyEntryQueue) {
            historyEntryPanel.add(h);
        }

        // Update title text.
        setTitle(Constants.HISTORY_TITLE+" ["+historyEntryQueue.size()+"/"+Constants.MAX_HISTORY_ENTRIES+"]");

        revalidate();
        // Continue with super implementation of repaint method.
        super.repaint();
    }

}
