package view.history;

import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.RPNCalculatorController;

public class HistoryWindow extends JFrame {

    private RPNCalculatorController controller = null;
    
    private JPanel historyWindowPanel = new JPanel();

    private Queue<HistoryEntry> historyEntryQueue = new LinkedList<HistoryEntry>();
    private JPanel historyEntryPanel = new JPanel();
    private JScrollPane historyEntryScrollPane = new JScrollPane(historyEntryPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public HistoryWindow(RPNCalculatorController controller) {
        this.controller = controller;

        setSize(300, 500);
        setTitle("HISTORY");

        historyEntryPanel.setLayout(new BoxLayout(historyEntryPanel, BoxLayout.Y_AXIS));
        historyEntryScrollPane.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        historyWindowPanel.setLayout(new BoxLayout(historyWindowPanel, BoxLayout.Y_AXIS));
        historyWindowPanel.add(historyEntryScrollPane);
        add(historyWindowPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void repaint() {
        // Add elements.
        historyEntryQueue = controller.getHistoryController().getResultHistory();
        historyEntryPanel.removeAll();
        for (HistoryEntry h: historyEntryQueue) {
            historyEntryPanel.add(h);
        }
        revalidate();
        // Continue with super implementation of repaint method.
        super.repaint();
    }

}
