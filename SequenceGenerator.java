package Tasks;

public class SequenceGenerator implements Runnable {

    private NumbersGenerator numbersGenerator;
    private int index;

    public SequenceGenerator(NumbersGenerator numbersGenerator, int index) {
        this.numbersGenerator = numbersGenerator;
        this.index = index;
    }

    @Override
    public void run() {
        numbersGenerator.printNumber(this.index);
    }
}