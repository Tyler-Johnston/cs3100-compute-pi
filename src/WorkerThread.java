public class WorkerThread implements Runnable{

    TaskQueue queue;
    ResultTable resultTable;

    public WorkerThread(TaskQueue q, ResultTable rt) {
        this.queue = q;
        this.resultTable = rt;
    }

    public int getNthDigit(int num) {

        Bpp calculator = new Bpp();
        int digit = calculator.getDecimal(num);
        String strNum = Integer.toString(digit);
        // if the length of Bpp()'s number is of size 8, then that digit of pi is 0
        if (strNum.length() == 8) return 0;
        // otherwise, return the first element in that number
        return Integer.parseInt(strNum.substring(0,1));
    }

    @Override
    public void run() {
            while (!this.queue.isEmpty()) {
                int digit = this.queue.getDigit();
                this.resultTable.insert(digit, getNthDigit(digit));
                if (this.queue.tenthComputation()) {
                    System.out.print(".");
                    System.out.flush();
                }
            }
        }
    }
