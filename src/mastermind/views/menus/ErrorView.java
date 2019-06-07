package mastermind.views.menus;

import mastermind.types.Error;
import santaTecla.utils.Console;

class ErrorView {

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
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	
	
}
