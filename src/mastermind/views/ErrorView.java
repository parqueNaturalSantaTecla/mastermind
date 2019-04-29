package mastermind.views;

import mastermind.models.Error;

public class ErrorView {

	protected static final String[] MESSAGES = { "Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), "Wrong proposed combination length" };

	protected Error error;

	protected ErrorView(Error error) {
		this.error = error;
	}
	
}
