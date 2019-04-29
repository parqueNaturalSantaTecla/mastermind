package mastermind.views;

import mastermind.utils.WithConsoleView;
import mastermind.models.Error;

class ErrorView extends WithConsoleView {

	private static final String[] MESSAGES = { "Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), "Wrong proposed combination length" };

	private Error error;

	private ErrorView(Error error) {
		this.error = error;
	}

//	String getMessage() {
//		return this.message;
//	}
	
	void write() {
		this.console.write(ErrorView.MESSAGES[this.error.ordinal()]);
	}

}
