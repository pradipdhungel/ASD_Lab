package counter.state;


import counter.model.Counter;

public abstract class CounterState {
    protected final Counter counter;

    protected CounterState(Counter counter) {
        this.counter = counter;
    }
    public abstract void addPoints();
    public abstract void subtractPoints();
}
