package model;

import java.util.LinkedList;
import java.util.Queue;

import config.Constants;

public class ResultHistory {

    private Queue<CalculatorResult> resultHistoryQueue = new LinkedList<CalculatorResult>();

    public ResultHistory() {
        //Example Results
        addResult(new CalculatorResult("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget nisi nisi. Phasellus euismod arcu sed elit tincidunt lobortis. Suspendisse vestibulum enim et nulla viverra maximus. Sed quis leo eros. Nulla nec tellus vitae diam porta vestibulum iaculis et ligula. Phasellus ultricies mauris quam. Pellentesque semper facilisis placerat. Duis consectetur euismod varius. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis in leo at ipsum malesuada aliquam. Donec dapibus neque at pellentesque sollicitudin. Duis vel ipsum vitae mi faucibus tristique. Pellentesque ante sem, posuere in dolor et, dapibus condimentum nulla. Donec congue at nisi sed tincidunt.", "5"));
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
