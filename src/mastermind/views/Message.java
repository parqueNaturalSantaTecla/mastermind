package mastermind.views;

enum Message {
	TURN("#turn attempt(s): "),
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
	
	String getMessage() {
		return this.message;
	}

}
