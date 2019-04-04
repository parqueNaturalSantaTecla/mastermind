package mastermind.controllers;

import mastermind.models.Game;
import mastermind.views.GameView;

public class GameController {
	
	private SecretCombinationController secretCombinationController;
	
	private Game game;
	
	private GameView gameView;
	
	public GameController() {
		this.secretCombinationController = new SecretCombinationController();
		this.game = new Game(this.secretCombinationController.getSecretCombination());
		this.gameView = new GameView(this.game);
	}

	public Game getGame() {
		return this.game;
	}
	
	

}
