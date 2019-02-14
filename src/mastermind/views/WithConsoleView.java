package mastermind.views;

import mastermind.utils.Console;

public abstract class WithConsoleView {

	protected Console console;

	public WithConsoleView() {
		this.console = new Console();
	}
	
}
