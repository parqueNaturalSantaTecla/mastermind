package mastermind.views;

import mastermind.models.Mastermind;
import santaTecla.utils.Observer;

abstract class Command extends santaTecla.utils.Command {
	
	protected Mastermind mastermind;
	
	protected Command(String title, Mastermind mastermind, Observer observer) {
		this.title = title;
		this.mastermind = mastermind;
		this.addObserver(observer);
	}

}
