package mastermind.models;

public class Mastermind {
	
	private Game game;
	
	public Mastermind(Game game) {
		this.game = game;
	}

	public SecretCombination getSecretCombination() {
		return this.game.getSecretCombination();
	}
	
}
