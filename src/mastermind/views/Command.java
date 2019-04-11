package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.utils.Observer;

public abstract class Command extends mastermind.utils.Command {
	
	protected Mastermind mastermind;
	
	protected Command(String title, Mastermind mastermind, Observer observer) {
		this.title = title;
		this.mastermind = mastermind;
		this.addObserver(observer);
	}

}
