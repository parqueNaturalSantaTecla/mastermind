package santaTecla.utils;

import mastermind.models.Session;

public abstract class Command extends WithConsoleView {

	protected String title;

	protected boolean isActive;
	
	protected Session session;
	
	protected Command(String title, Session session) {
		this.title = title;
		this.session = session;
	}
	
	public abstract void updateIsActive();

	protected boolean isActive() {
		return this.isActive;
	}

	String getTitle() {
		return this.title;
	}

}
