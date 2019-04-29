package mastermind.views.console;

import mastermind.models.Error;
import mastermind.utils.Console;

public class ErrorView extends mastermind.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
