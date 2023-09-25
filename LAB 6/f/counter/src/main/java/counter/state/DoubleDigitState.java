package counter.state;

import counter.Counter;

public class DoubleDigitState extends CounterState {
    protected DoubleDigitState(Counter counter) {
        super(counter);
    }

    @Override
    public void addPoints() {
        int count=counter.getCount()+2;
        counter.setCount(count);
        checkForUpdate();

    }
    @Override
    public void subtractPoints() {
        int count=counter.getCount()-2;
        counter.setCount(count);
        checkForUpdate();

    }
    private void checkForUpdate() {
        int count=counter.getCount();
        if(count>99){
            CounterState state=new TripleDigitState(counter);
            counter.setState(state);
        }
        if (counter.getCount()<9){
            CounterState state= new SingleDigitState(counter);
            counter.setState(state);
        }
    }


}
