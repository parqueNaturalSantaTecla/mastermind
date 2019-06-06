package mastermind.views;

import santaTecla.utils.Console;

enum MessageView {
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-(");

	private String message;
	
	private MessageView(String message) {
		this.message = message;
	}

	void write() {
		new Console().write(this.message);
	}

	void writeln() {
		new Console().writeln(this.message);
	}

	void writeln(int attempts) {
		new Console().writeln(this.message.replaceAll("#attempts", "" + attempts));
	}

	void writeln(int blacks, int whites) {
		new Console().writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
	}

}
