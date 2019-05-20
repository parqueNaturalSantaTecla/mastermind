package mastermind.controllers;

import java.util.List;

import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public class PlayController extends AcceptorController {

	private ProposalController proposalController;

	private UndoController undoController;

	private RedoController redoController;

	PlayController(Session session) {
		super(session);
		this.proposalController = new ProposalController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
	}

	public Error addProposedCombination(List<Color> colors) {
		return this.proposalController.addProposedCombination(colors);
	}

	public void undo() {
		this.undoController.undo();
	}

	public void redo() {
		this.redoController.redo();
	}

	public boolean undoable() {
		return this.undoController.undoable();
	}

	public boolean redoable() {
		return this.redoController.redoable();
	}

	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	public boolean isLooser() {
		return this.proposalController.isLooser();
	}

	public int getAttempts() {
		return this.proposalController.getAttempts();
	}

	public List<Color> getColors(int i) {
		return this.proposalController.getColors(i);
	}

	public int getBlacks(int i) {
		return this.proposalController.getBlacks(i);
	}

	public int getWhites(int i) {
		return this.proposalController.getWhites(i);
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
