package mastermind.controllers;

import mastermind.models.Game;

public class PlayController extends Controller{
	
	ProposalController proposalController;

	PlayController(Game game, State state) {
		super(game, state);
		this.proposalController = new ProposalController(this.game, this.state);
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
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
		
	}
}
