package mastermind.views;

import santaTecla.utils.Console;

public enum MessageView {
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	NEW_GAME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-("),
	PROPOSE_COMMAND("Propose Combination"),
	UNDO_COMMAND("Undo previous Proposal"),
	REDO_COMMAND("Redo previous Proposal"), 
	NEW_LINE("");

	private String message;
	
	private Console console;
	
	private MessageView(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

	public void writeln(int attempts) {
		this.console.writeln(this.message.replaceAll("#attempts", ""+attempts));
	}

	public void writeln() {
		this.console.writeln(this.message);
	}

	public void writeln(int blacks, int whites) {
		this.console.writeln(this.message.replaceAll("#blacks", ""+blacks).replaceAll("#whites", ""+whites));
	}

	public void write() {
		this.console.write(this.message);
	}

}
