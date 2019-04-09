package mastermind.views;

import mastermind.utils.Console;

public enum Error {
	DUPLICATED("Repeated colors"),
	WRONG_CHARACTERS("Wrong colors, they must be: " + Color.allInitials()),
	WRONG_LENGTH("Wrong proposed combination length");
	
	private String message;
	
	private Error(String message) {
		this.message = message;
	}

	public void write() {
		new Console().write(this.message);
	}
	
}
