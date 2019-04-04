package mastermind.controllers;

import mastermind.models.Mastermind;
import mastermind.views.MastermindView;

public class MastermindController {
	
	private GameController gameController;
	
	private Mastermind mastermind;
	
	private MastermindView mastermindView;
	
	public MastermindController() {
		this.gameController = new GameController();
		this.mastermind = new Mastermind(this.gameController.getGame());
		this.mastermindView = new MastermindView(this.mastermind);
	}
	
	protected void play() {
		this.mastermindView.write();
		
		
//		Controller controller;
//		do {
//			controller = this.controllers.get(this.session.getValueState());
//			if (controller != null) {
//				controller.control();
//			}
//		} while (controller != null);
	}

	public static void main(String[] args) {
		new MastermindController().play();
	}

}
