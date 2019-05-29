package mastermind.models;

import java.util.List;

import mastermind.types.Color;

public class Session {

	private State state;
	
	private Game game;
	
	private Registry registry;
	
	public Session() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
	}

	public void next() {
		this.state.next();		
	}

	public void addProposedCombination(List<Color> colors) {
		this.game.addProposedCombination(colors);
		this.registry.registry();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void isNewGame() {
		this.game.clear();
		this.state.reset();	
		this.registry.reset();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

	public int getWidth() {
		return this.game.getWidth();
	}

	public List<Color> getColors(int position) {
		return this.game.getColors(position);
	}

	public int getBlacks(int i) {
		return this.game.getBlacks(i);
	}

	public int getWhites(int i) {
		return this.game.getWhites(i);
	}

	public int getAttempts() {
		return this.game.getAttempts();
	}

	public StateValue getValueState() {
		return this.state.getValueState();
	}
	
}
