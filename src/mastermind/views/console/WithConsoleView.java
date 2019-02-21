package mastermind.views.console;

import mastermind.utils.Console;

abstract class WithConsoleView {

	protected Console console;

	protected WithConsoleView() {
		this.console = new Console();
	}
	
}
