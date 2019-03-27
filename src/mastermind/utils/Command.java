package mastermind.utils;

public abstract class Command extends WithConsoleView {

	protected String title;

	protected Boolean isActive;
	
	protected Command(String title) {
		this.title = title;
		this.isActive = false;
	}
	
	public abstract void setActive(Boolean isActive);

	protected abstract boolean isActive();

	String getTitle() {
		return this.title;
	}

}
