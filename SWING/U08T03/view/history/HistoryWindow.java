package view.history;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import constants.Constants;
import controller.RPNCalculatorController;
import view.RPNCalculatorView;

public class HistoryWindow extends JFrame {

    private RPNCalculatorController controller = null;
    private RPNCalculatorView view = null;
    
    private JPanel historyWindowPanel = new JPanel();

    private Queue<HistoryEntry> historyEntryQueue = new LinkedList<HistoryEntry>();
    private HistoryEntryPanel historyEntryPanel = new HistoryEntryPanel();
    private JScrollPane historyEntryScrollPane = new JScrollPane(historyEntryPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    public HistoryWindow(RPNCalculatorView view, RPNCalculatorController controller) {
        this.controller = controller;
        this.view = view;

        setSize(300, 500);
        setTitle(Constants.HISTORY_TITLE);

        historyEntryScrollPane.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        historyWindowPanel.setLayout(new BoxLayout(historyWindowPanel, BoxLayout.Y_AXIS));
        historyWindowPanel.add(historyEntryScrollPane);
        add(historyWindowPanel);

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        repaint();
    }

    @Override
    public void repaint() {
        // Add elements.
        historyEntryQueue = controller.getResultHistory();
        historyEntryPanel.removeAll();
        for (HistoryEntry h: historyEntryQueue) {
            historyEntryPanel.add(h);
        }

        revalidate();
        // Continue with super implementation of repaint method.
        super.repaint();
    }

}
