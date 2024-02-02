import java.util.ArrayList;
import java.util.LinkedList;

public class TaskQueue {

    private LinkedList<Integer> queue = new LinkedList<Integer>();
    private ArrayList<Integer> array = new ArrayList<Integer>();
    private int numberOfComputations = 0;

    public TaskQueue() {
        // add elements onto the array
        for (int i = 1; i < 1001; i++) {
            this.array.add(i);
        }
        // shuffle the array list
        java.util.Collections.shuffle(array);

        // add the randomized sequence of numbers into the queue
        this.queue.addAll(array);
    }

    public synchronized int getDigit() {
        int digit = this.queue.get(0);
        dequeue();
        return digit;
    }

    public void dequeue() {
        if (!this.queue.isEmpty()) {
            this.queue.remove(0);
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public synchronized boolean tenthComputation() {
        numberOfComputations++;
        if (numberOfComputations == 10) {
            numberOfComputations = 0;
            return true;
        }
        return false;
    }
}