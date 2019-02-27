package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.Session;

public class PlayController extends AcceptorController{
	
	ProposalController proposalController;

	PlayController(Session session) {
		super(session);
		this.proposalController = new ProposalController(this.session);
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

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
		
	}
}
