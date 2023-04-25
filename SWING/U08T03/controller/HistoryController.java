package controller;

import java.util.LinkedList;
import java.util.Queue;

import model.RPNCalculatorModel;
import model.CalculatorResult;
import view.history.HistoryEntry;

public class HistoryController {

    private RPNCalculatorModel model = null;

    public HistoryController(RPNCalculatorModel model) {
        this.model = model;
    }

    public Queue<HistoryEntry> getResultHistory() {
        Queue<CalculatorResult> resultQueue = model.getResultHistory().getResultHistoryQueue();
        Queue<HistoryEntry> entryQueue = new LinkedList<HistoryEntry>();

        for (CalculatorResult r: resultQueue) {
            entryQueue.add(new HistoryEntry(r.getSentence(), r.getResult()));
        }

        return entryQueue;
    }

    public void addResult(CalculatorResult result) {
        model.getResultHistory().addResult(result);
    }
    
}
