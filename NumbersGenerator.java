package Tasks;

public class NumbersGenerator {
    private int currNumber = 1;
    private int numOfThreads;
    private int totalNumbersInSeq;

    public NumbersGenerator(final int numOfThreads, final int totalNumbersInSeq) {
        this.numOfThreads = numOfThreads;
        this.totalNumbersInSeq = totalNumbersInSeq;
    }

    public void printNumber(int index) {
        synchronized (this) {
            while(currNumber < totalNumbersInSeq-1) {
                while (currNumber % numOfThreads != index) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " : " + currNumber++);
                notifyAll();
            }
        }
    }
}