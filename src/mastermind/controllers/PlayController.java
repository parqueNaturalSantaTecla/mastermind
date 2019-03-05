package mastermind.controllers;

import mastermind.models.Session;

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

	public int proposeCombination(int[] codes) {
		return this.proposalController.proposeCombination(codes);
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

	public int[][][] getAllCodes() {
		return this.proposalController.getAllCodes();
	}

	public int getTurn() {
		return this.proposalController.getTurn();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
