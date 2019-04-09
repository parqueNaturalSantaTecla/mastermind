package mastermind.models;

public class SessionImplementation implements Session {
	
	private State state;

	private Game game;

	private Registry registry;

	private String name;

	public SessionImplementation() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
		this.name = null;
	}

	public void next() {
		this.state.next();
	}

	public void proposeCombination(ProposedCombination proposedCombination) {
		this.game.proposeCombination(proposedCombination);
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

	public void resume() {
		this.game.clear();
		this.state.reset();
		this.registry.reset();
		this.name = null;
	}

	public void resetRegistry() {
		this.registry.reset();
	}

	public void setStateValue(StateValue stateValue) {
		this.state.setStateValue(stateValue);
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

	public boolean hasName() {
		return this.name != null;
	}

	public Game getGame() {
		return this.game;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getWidth() {
		return this.game.getWidth();
	}

	@Override
	public StateValue getValueState() {
		return this.state.getValueState();
	}

}
