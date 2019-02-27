package mastermind.models;

import mastermind.controllers.State;

public class Session {

	private State state;
	
	private Game game;
	
	public Session() {
		this.state = new State();
		this.game = new Game();
	}

	public int getWidth() {
		return this.game.getWidth();
	}

	public void next() {
		this.state.next();		
	}

	public void proposeCombination(ProposedCombination proposedCombination) {
		this.game.proposeCombination(proposedCombination);
		
	}

	public boolean isWinner() {
		return this.game.isWinner();
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
}
