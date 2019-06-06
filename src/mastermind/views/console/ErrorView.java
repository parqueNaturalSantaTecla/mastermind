package mastermind.views.console;

import mastermind.types.Error;
import santaTecla.utils.Console;

class ErrorView extends mastermind.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
