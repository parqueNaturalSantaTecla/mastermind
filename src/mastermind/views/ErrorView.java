package mastermind.views;

import mastermind.utils.WithConsoleView;
import mastermind.models.Error;

class ErrorView extends WithConsoleView {

	private static final String[] MESSAGES = { "Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), "Wrong proposed combination length" };

	private Error error;

	ErrorView(Error error) {
		this.error = error;
	}
	
	void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}

}
