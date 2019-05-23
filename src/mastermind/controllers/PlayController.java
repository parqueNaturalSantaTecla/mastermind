package mastermind.controllers;

import java.util.List;

import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public abstract class PlayController extends GameController {

	protected PlayController(Session session) {
		super(session);
	}

	public abstract Error addProposedCombination(List<Color> colors);

	public abstract void undo();

	public abstract void redo();

	public abstract void next();

	public abstract boolean undoable();

	public abstract boolean redoable();

	public abstract boolean isWinner();

	public abstract boolean isLooser();

	public abstract List<Color> getColors(int position);
	
	public abstract int getBlacks(int position);
	
	public abstract int getWhites(int position);

	public abstract int getAttempts();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
