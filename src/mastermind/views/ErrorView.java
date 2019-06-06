package mastermind.views;

import mastermind.types.Error;
import santaTecla.utils.WithConsoleView;

class ErrorView extends WithConsoleView{

	static final String[] MESSAGES = { 
		"Repeated colors",
		"Wrong colors, they must be: " + ColorView.allInitials(), 
		"Wrong proposed combination length" };

	Error error;

	ErrorView(Error error) {
		this.error = error;
	}
	
	String getMessage() {
		return ErrorView.MESSAGES[this.error.ordinal()];
	}
	
	void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	
	
}
