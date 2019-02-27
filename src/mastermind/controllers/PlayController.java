package mastermind.controllers;

import mastermind.models.Session;

public class PlayController extends AcceptorController{
	
	ProposalController proposalController;
	
	UndoController undoController;
	
	RedoController redoController;

	PlayController(Session session) {
		super(session);
		this.proposalController = new ProposalController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
	}
	
	public int proposeCombination(int[] codes) {
		return this.proposalController.proposeCombination(codes);
	}
	
	public int[][][] getAllCodes() {
		return this.proposalController.getAllCodes();
	}
	
	public int getTurn() {
		return this.proposalController.getTurn();
	}
	
	public boolean isWinner() {
		return this.proposalController.isWinner();
	}

	public boolean isLooser() {
		return this.proposalController.isLooser();
	}
	
	public boolean undoable() {
		return this.session.undoable();
	}
	
	public boolean redoable() {
		return this.session.redoable();
	}

	public void undo() {
		this.session.undo();		
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);		
	}

	public void redo() {
		this.session.redo();
	}

	public void printMementos() {
		this.session.printMementos();
	}
	
}
