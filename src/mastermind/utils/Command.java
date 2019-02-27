package mastermind.utils;

public abstract class Command extends WithConsoleView{
	
	protected String title;
	
	public abstract void execute();
	
	public abstract boolean isActive();
	
	public String getTitle() {
		return this.title;
	}

}
