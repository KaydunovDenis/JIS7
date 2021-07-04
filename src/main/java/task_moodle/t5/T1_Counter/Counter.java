package task_moodle.t5.T1_Counter;

public class Counter {
    private int value;
    private int step;

    public Counter() {
        this.value = 0;
        this.step = 1;
    }

    public void increment() {
        if (value + step <= 100)
            value = value + step;
    }

    public void decrement() {
        if (value - step >= 0)
            value = value - step;
    }

    public void reset() {
        setValue(0);
        setStep(1);
    }

    public void setValue(int value) {
        if (value >= 0 && value <= 100)
            this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setStep(int step) {
        if (step >= 1 && step <= 10)
            this.step = step;
    }

    public int getStep() {
        return step;
    }
}
