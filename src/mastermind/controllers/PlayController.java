package mastermind.controllers;

import mastermind.models.Session;

public abstract class PlayController extends AcceptorController {

	protected PlayController(Session session) {
		super(session);
	}

	public abstract int proposeCombination(int[] codes);

	public abstract void undo();

	public abstract void redo();

	public abstract boolean undoable();

	public abstract boolean redoable();

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	public abstract int[][][] getAllCodes();

	public abstract int getTurn();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
