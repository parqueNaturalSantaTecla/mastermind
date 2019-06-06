package mastermind;

import santaTecla.utils.Console;

enum Message {
	ATTEMPTS("#attempts attempt(s): "), 
	SECRET("*"), 
	RESUME("Do you want to continue"), 
	RESULT(" --> #blacks blacks and #whites whites"), 
	PROPOSED_COMBINATION("Propose a combination: "), 
	TITLE("----- MASTERMIND -----"), 
	WINNER("You've won!!! ;-)"), 
	LOOSER("You've lost!!! :-(");

	private String message;
	
	private Console console;

	private Message(String message) {
		this.message = message;
	}

	void write() {
		this.console.write(this.message);
	}

	void writeln() {
		this.console.writeln(this.message);
	}

	void writeln(int attempts) {
		this.console.writeln(this.message.replaceAll("#attempts", "" + attempts));
	}

	void writeln(int blacks, int whites) {
		this.console.writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
	}

}
