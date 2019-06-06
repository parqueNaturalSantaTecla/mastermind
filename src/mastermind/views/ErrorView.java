package mastermind.views;

import mastermind.models.Error;
import santaTecla.utils.WithConsoleView;

class ErrorView extends WithConsoleView {

	private static final String[] MESSAGES = { "Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), "Wrong proposed combination length" };
	
	void writeln(Error error) {
		this.console.writeln(ErrorView.MESSAGES[error.ordinal()]);
	}

}
