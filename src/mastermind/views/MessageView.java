package mastermind.views;

public enum MessageView {
	ATTEMPTS("#turn attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
	SAVE("Do you want to save the game?"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-("),
	OPTION("----- Choose one option -----"),
	PROPOSE_COMMAND("Propose Combination"),
	UNDO_COMMAND("Undo previous Proposal"),
	REDO_COMMAND("Redo previous Proposal"),
	NEWGAME_COMMAND("Start a new game"),
	EXIT_COMMAND("Exit game"),
	OPENGAME_COMMAND("Open a saved game"),
	NAME("Name: ");

	private String message;
	
	private MessageView(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
