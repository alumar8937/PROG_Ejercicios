package model;

import java.util.LinkedList;
import java.util.Queue;

import config.Constants;

public class ResultHistory {
    
    private static Queue<CalculatorResult> resultHistoryQueue = new LinkedList<CalculatorResult>();
    
    public static Queue<CalculatorResult> getResultHistoryQueue() {
        return resultHistoryQueue;
    }

    public static void addResult(CalculatorResult result) {
        resultHistoryQueue.add(result);
        if (resultHistoryQueue.size() > Constants.MAX_HISTORY_ENTRIES) { // Poll head of queue when maximum result count has been reached.
            resultHistoryQueue.poll();
        }
    }

}
