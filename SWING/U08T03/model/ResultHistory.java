package model;

import java.util.LinkedList;
import java.util.Queue;

public class ResultHistory {

    private Queue<CalculatorResult> resultHistoryQueue = new LinkedList<CalculatorResult>();

    public ResultHistory() {
        resultHistoryQueue.add(new CalculatorResult("lorem ipsum akjñwa wñlkja ñlkfjaaseñ aeñlkfjseañlkfjña aseñklfjañlkfr aeñlkfj","a"));
        resultHistoryQueue.add(new CalculatorResult("2","b"));
        resultHistoryQueue.add(new CalculatorResult("3","c"));
        resultHistoryQueue.add(new CalculatorResult("4","d"));
    }
    
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
