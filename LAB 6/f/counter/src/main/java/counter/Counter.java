package counter;

import counter.state.CounterState;

public class Counter extends ObservableClass {
	private int count=0;
	private CounterState counterState;
	public void setState(CounterState counterState){
		this.counterState=counterState;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void increment(){
		count++;
		notify(count);
	}
	public void decrement(){
		count--;
		notify(count);

	}


}
