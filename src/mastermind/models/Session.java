package mastermind.models;

import mastermind.controllers.State;

public class Session {

	private State state;
	
	private Game game;
	
	private Registry registry;
	
	public Session() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
	}

	public int getWidth() {
		return this.game.getWidth();
	}

	public void next() {
		this.state.next();		
	}

	public void proposeCombination(ProposedCombination proposedCombination) {
		this.game.proposeCombination(proposedCombination);
		this.registry.registry();
	}

	public boolean isWinner() {
		if(this.game.getTurn()>0) {
			return this.game.isWinner();
		}
		return false;
	}

	public boolean isLooser() {
		return this.game.isLooser();
	}

	public int[][][] getCodes() {
		return this.game.getCodes();
	}

	public int getTurn() {
		return this.game.getTurn();
	}

	public void resume() {
		this.game.clear();
		this.state.reset();		
	}

	public Object getValueState() {
		return this.state.getValueState();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo(this.game);
//		this.registry.registry();
	}

	public void redo() {
		this.registry.redo(this.game);
//		this.registry.registry();
	}

	public void printMementos() {
		this.registry.printMementos();
	}
}
