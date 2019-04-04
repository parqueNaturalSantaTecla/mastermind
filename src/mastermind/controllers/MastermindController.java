package mastermind.controllers;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Event;
import mastermind.mvcUtils.Observed;
import mastermind.mvcUtils.Observer;
import mastermind.mvcUtils.ProposeEvent;
import mastermind.mvcUtils.RedoEvent;
import mastermind.mvcUtils.UndoEvent;
import mastermind.views.MastermindView;

public class MastermindController implements Observer{
	
	private GameController gameController;
	
	private Mastermind mastermind;
	
	private MastermindView mastermindView;
	
	public MastermindController() {
		this.gameController = new GameController();
		this.mastermind = new Mastermind(this.gameController.getGame());
		this.mastermindView = new MastermindView(this.mastermind, this);
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

	@Override
	public void update(Observed observed, Event event) {
		if (event instanceof ProposeEvent) {
			this.gameController.proposeCombination();
			this.mastermind.proposeCombination();
		} else if (event instanceof UndoEvent) {
			System.out.println("Undo");
			this.mastermind.undo();
		} else if (event instanceof RedoEvent) {
			System.out.println("redo");
			this.mastermind.redo();
		}
	}

}
