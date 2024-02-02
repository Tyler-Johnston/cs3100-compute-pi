import java.util.HashMap;

public class ResultTable {

    private HashMap<Integer, Integer> map = new HashMap<>();

    public synchronized void insert(int position, int computation) {
        this.map.put(position, computation);
    }

    public synchronized int getComputation(int position) {
        return this.map.get(position);
    }

    public int getSize() {
        return this.map.size();
    }

}
