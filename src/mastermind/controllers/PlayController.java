package mastermind.controllers;

import java.util.List;

import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public abstract class PlayController extends AcceptorController {

	protected PlayController(Session session) {
		super(session);
	}

	public abstract Error addProposedCombination(List<Color> colors);

	public abstract void undo();

	public abstract void redo();

	public abstract boolean undoable();

	public abstract boolean redoable();

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	public abstract List<Color> getColors(int i);

	public abstract int getAttempts();
	
	public abstract int getBlacks(int i);
	
	public abstract int getWhites(int i);

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
