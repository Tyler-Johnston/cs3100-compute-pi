public class Assign4 {

    public static void main(String[] args) {
        try {
            TaskQueue q = new TaskQueue();
            ResultTable rt = new ResultTable();
            Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];

            // initialize each worker thread and join them upon completion of computation
            long timeStart = System.currentTimeMillis();
            for (int thread = 0; thread < Runtime.getRuntime().availableProcessors(); thread++){
                threads[thread] = new Thread(new WorkerThread(q, rt));
                threads[thread].start();
            }
            for (Thread t : threads) {
                t.join();
            }
            long timeEnd = System.currentTimeMillis();

            // combine the digits of pi in order to display the final result starting with '3.'
            System.out.println(""); // new line so the dots and the digits of pi are on separate lines
            StringBuilder sb = new StringBuilder();
            sb.append("3.");
            int resultTableSize = rt.getSize();
            for (int i=1; i<resultTableSize; i++) {
                sb.append(rt.getComputation(i));
            }

            // print the digits of pi and the time it took to compute
            System.out.println(sb);
            System.out.println("Pi Computation took " + (timeEnd - timeStart) + " ms");
        }
        catch(Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }
}