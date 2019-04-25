package mastermind;

import mastermind.utils.Console;

enum Message {
	TURN("#attempts attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-(");

	private String message;
	
	private Message(String message) {
		this.message = message;
	}

	void write() {
		new Console().write(this.message);
	}

	void write(int attempts) {
		new Console().write(this.message.replaceAll("#attempts", ""+attempts));
	}

	void write(int blacks, int whites) {
		new Console().writeln(this.message.replaceFirst("#blacks", "" + blacks)
				.replaceFirst("#whites", "" + whites));
	}

}
