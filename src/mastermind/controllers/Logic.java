package mastermind.controllers;

import mastermind.models.Game;

public class Logic {
	
	private State state;
	
	private Game game;
	
	private StartController startController;
	
	private ProposalController proposalController;
	
	private ResumeController resumeController;
		
	public Logic() {
		this.state = new State();
		this.game = new Game();
		this.startController = new StartController(this.game, this.state);
		StateValue.INITIAL.set(this.startController);
		this.proposalController = new ProposalController(this.game, this.state);
		StateValue.IN_GAME.set(this.proposalController);
		this.resumeController = new ResumeController(this.game, this.state);
		StateValue.FINAL.set(this.resumeController);
	}
	
	public Controller getController() {
		return this.state.getValueState().getController();
	}
	
}
