package mastermind.views;

import mastermind.models.Game;
import mastermind.utils.WithConsoleView;

public class StartView extends WithConsoleView {

	private Game game;
	
	public StartView(Game game) {
		this.game = game;
	}
	
	public void write() {
		this.console.writeln(MessageView.TITLE.getMessage());
		new SecretCombinationView(this.game.getSecretCombination()).writeln();
	}

}
