package santaTecla.utils;

public abstract class Command extends WithConsoleView {

	protected String title;

	protected boolean isActive;
	
	protected Command(String title) {
		this.title = title;
	}
	
	public abstract void updateIsActive();

	protected boolean isActive() {
		return this.isActive;
	}

	String getTitle() {
		return this.title;
	}

}
