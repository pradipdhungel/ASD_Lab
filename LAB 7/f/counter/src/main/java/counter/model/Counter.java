package counter.model;

import counter.cors.Handler;
import counter.dao.CounterDAO;
import counter.observer.ObservableClass;
import counter.state.CounterState;


public class Counter extends ObservableClass {
	private int count=0;
	private CounterState counterState;

	private CounterDAO counterDAO;

	private Handler handler;

	public Counter(Handler handler) {
		super();
		this.handler = handler;
		this.counterDAO=new CounterDAO();
	}
	public void setCounterState(CounterState counterState){
		this.counterState=counterState;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void increment(){
		counterState.addPoints();
		notify(count);
		handler.handle(count);
		counterDAO.saveCount(count);
	}
	public void  decrement(){
		counterState.subtractPoints();
		notify(count);
		handler.handle(count);
		counterDAO.saveCount(count);
	}
}
