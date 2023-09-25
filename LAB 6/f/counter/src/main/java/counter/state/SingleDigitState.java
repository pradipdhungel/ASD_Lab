package counter.state;

import counter.Counter;

public class SingleDigitState extends CounterState {
    protected SingleDigitState(Counter counter) {
        super(counter);
    }

    @Override
    public void addPoints() {
        int count=counter.getCount()+1;
        counter.setCount(count);
        checkForUpdate();
    }



    @Override
    public void subtractPoints() {
        int count=counter.getCount()-1;
        counter.setCount(count);
        checkForUpdate();
    }
    private void checkForUpdate() {
        int count=counter.getCount();
        if(count>9){
            CounterState state=new DoubleDigitState(counter);
            counter.setState(state);
        }
    }
}
