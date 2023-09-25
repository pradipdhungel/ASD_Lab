package counter.state;

import counter.Counter;

public class TripleDigitState extends CounterState{
    protected TripleDigitState(Counter counter) {
        super(counter);
    }

    @Override
    public void addPoints() {
        int count=counter.getCount()+3;
        counter.setCount(count);
        checkForUpdate();
    }
    @Override
    public void subtractPoints() {
        int count=counter.getCount()-3;
        counter.setCount(count);
        checkForUpdate();
    }
    private void checkForUpdate() {
        int count =counter.getCount();
        if (count<99){
            CounterState state=new DoubleDigitState(counter);
            counter.setState(state);
        }
    }


}
