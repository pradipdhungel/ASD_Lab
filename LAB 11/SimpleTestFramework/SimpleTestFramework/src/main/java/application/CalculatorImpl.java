package application;

public class CalculatorImpl implements Calculator {
    private int calVal = 0;

    @Override
    public void resetValue() {
        calVal = 0;
    }

    @Override
    public int add(int newVal) {
        calVal += newVal;
        return calVal;
    }

    @Override
    public int subtract(int newVal) {
        calVal -= newVal;
        return calVal;
    }
}
