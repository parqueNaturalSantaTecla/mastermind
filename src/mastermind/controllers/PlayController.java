package mastermind.controllers;

import mastermind.models.Session;

public abstract class PlayController extends GameController {

	protected PlayController(Session session) {
		super(session);
	}

	public abstract int proposeCombination(int[] codes);

	public abstract void undo();

	public abstract void redo();

	public abstract void next();

	public abstract boolean undoable();

	public abstract boolean redoable();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
