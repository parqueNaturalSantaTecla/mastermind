package mastermind.utils;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Observed;
import mastermind.mvcUtils.Observer;

public abstract class Command extends Observed {

	protected String title;

	protected Boolean isActive;
	
	protected Mastermind mastermind;
	
	protected Command(String title, Mastermind mastermind, Observer observer) {
		this.title = title;
		this.mastermind = mastermind;
		this.addObserver(observer);
	}

	protected boolean isActive() {
		return this.isActive;
	}

	String getTitle() {
		return this.title;
	}
	
	public abstract void updateIsActive();

	public abstract void execute();

}
