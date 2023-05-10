package view.teamView;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import controller.Controller;
import model.Team;


public class TeamViewWindow extends JFrame {

    private Team equipo = null;
    
    private JPanel historyWindowPanel = new JPanel();

    private Queue<playerEntry> playerEntryQueue = new LinkedList<playerEntry>();
    private playerPanel playerPanel = new playerPanel();
    private JScrollPane playerScrollPane = new JScrollPane(playerPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    public TeamViewWindow(Team equipo) {

        this.equipo = equipo;

        setSize(300, 500);
        setTitle(equipo.getName());

        playerScrollPane.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        historyWindowPanel.setLayout(new BoxLayout(historyWindowPanel, BoxLayout.Y_AXIS));
        historyWindowPanel.add(playerScrollPane);
        add(historyWindowPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        repaint();

        setVisible(true);
    }

    @Override
    public void repaint() {
        // Add elements.
        playerEntryQueue = Controller.getPlayerEntries(equipo);
        playerPanel.removeAll();
        for (playerEntry h: playerEntryQueue) {
            playerPanel.add(h);
        }

        revalidate();
        // Continue with super implementation of repaint method.
        super.repaint();
    }

}
