package mastermind.mvcUtils;

import java.util.ArrayList;

import mastermind.utils.WithConsoleView;

public class Observed extends WithConsoleView{
	
	private ArrayList<Observer> observers;
	
	public Observed () {
		this.observers = new ArrayList<Observer>();
	}
	
	public void registry(Observer observer) {
		this.observers.add(observer);
	}
	
	public void notify() {
		for (Observer observer: this.observers) {
			observer.update(Event event);
		}
	}

}
