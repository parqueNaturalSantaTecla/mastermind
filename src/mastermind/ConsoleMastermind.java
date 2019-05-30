package mastermind;

import mastermind.models.Game;
import mastermind.views.console.ConsoleView;

public class ConsoleMastermind {
	
	private Game game;

	private ConsoleView consoleView;

	private ConsoleMastermind() {
		this.game = new Game();
		this.consoleView = new ConsoleView(this.game);
	}

	private void play() {
		this.consoleView.interact();
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
	
}
