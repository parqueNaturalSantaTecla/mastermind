package mastermind.views;

import mastermind.models.Game;

public class StartView {

	private Game game;
	
	public StartView(Game game) {
		this.game = game;
	}
	
	public void write() {
		MessageView.TITLE.writeln();
		new SecretCombinationView(this.game.getSecretCombination()).writeln();
	}

}
