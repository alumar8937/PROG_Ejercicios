package model;

import java.util.LinkedList;
import java.util.Queue;

import constants.Constants;

public class ResultHistory {

    private Queue<CalculatorResult> resultHistoryQueue = new LinkedList<CalculatorResult>();

    public ResultHistory() {}
    
    public Queue<CalculatorResult> getResultHistoryQueue() {
        return resultHistoryQueue;
    }

    public void addResult(CalculatorResult result) {
        resultHistoryQueue.add(result);
        if (resultHistoryQueue.size() > Constants.MAX_HISTORY_ENTRIES) {
            resultHistoryQueue.poll();
        }
    }

}
