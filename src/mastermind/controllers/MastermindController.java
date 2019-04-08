package mastermind.controllers;

import mastermind.events.Event;
import mastermind.events.NewGameEvent;
import mastermind.events.ProposeEvent;
import mastermind.events.RedoEvent;
import mastermind.events.UndoEvent;
import mastermind.models.Mastermind;
import mastermind.utils.Observed;
import mastermind.utils.Observer;
import mastermind.views.MastermindView;

class MastermindController implements Observer{
	
	private GameController gameController;
	
	private Mastermind mastermind;
	
	private MastermindView mastermindView;
	
	MastermindController() {
		this.clear();
	}
	
	void clear() {
		this.gameController = new GameController();
		this.mastermind = new Mastermind(this.gameController.getGame());
		this.mastermindView = new MastermindView(this.mastermind, this);	
		this.mastermindView.addObserver(this);
		this.mastermind.addObserver(this.mastermindView);	
	}
	
	void play() {
		this.mastermindView.write();
	}

	@Override
	public void update(Observed observed, Event event) {
		if (event instanceof ProposeEvent) {
			this.gameController.proposeCombination();
			this.mastermind.proposeCombination();
		} else if (event instanceof UndoEvent) {
			this.mastermind.undo();
			this.gameController.reset();			
		} else if (event instanceof RedoEvent) {
			this.mastermind.redo();
			this.gameController.reset();
		} else if (event instanceof NewGameEvent) {
			this.clear();
			this.mastermind.clear();
			this.play();
		}
	}

	public static void main(String[] args) {
		new MastermindController().play();
	}

}
