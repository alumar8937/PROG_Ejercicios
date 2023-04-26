package controller;

import java.util.LinkedList;
import java.util.Queue;

import model.ResultHistory;
import model.CalculatorResult;
import view.history.HistoryEntry;

public class HistoryController {

    public static Queue<HistoryEntry> getResultHistory() {
        Queue<CalculatorResult> resultQueue = ResultHistory.getResultHistoryQueue();
        Queue<HistoryEntry> entryQueue = new LinkedList<HistoryEntry>();

        for (CalculatorResult r: resultQueue) {
            entryQueue.add(new HistoryEntry(r.getSentence(), r.getResult(), r.wasSyntaxError()));
        }

        return entryQueue;
    }

    public static void addResult(CalculatorResult result) {
        ResultHistory.addResult(result);
    }
    
}
