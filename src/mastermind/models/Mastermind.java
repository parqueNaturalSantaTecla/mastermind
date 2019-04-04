package mastermind.models;

public class Mastermind {
	
	private Game game;
	
	private Registry registry;
	
	public Mastermind(Game game) {
		this.game = game;
		this.registry = new Registry(this.game);
	}

	public SecretCombination getSecretCombination() {
		return this.game.getSecretCombination();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}
	
	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void proposeCombination() {
		this.registry.registry();
	}

//	public void next() {
//		this.state.next();		
//	}

//
//	public void resume() {
//		this.game.clear();
//		this.state.reset();	
//		this.registry.reset();
//	}
//
//	public StateValue getValueState() {
//		return this.state.getValueState();
//	}
//
//	public Game getGame() {
//		return this.game;
//	}
	
}
