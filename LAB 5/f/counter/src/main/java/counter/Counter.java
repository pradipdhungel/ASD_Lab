package counter;

public class Counter extends ObservableClass {
	private int counter=0;
	public void increment(){
		counter++;
		notify(counter);
	}
	public void decrement(){
		counter--;
		notify(counter);

	}


}
