package mastermind.controllers;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Event;
import mastermind.mvcUtils.NewGameEvent;
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
		this.mastermindView.addObserver(this);
		this.mastermind.addObserver(this.mastermindView);
	}
	
	protected void play() {
		this.mastermindView.write();
	}

	@Override
	public void update(Observed observed, Event event) {
		if (event instanceof ProposeEvent) {
			this.gameController.proposeCombination();
			this.mastermind.proposeCombination();
		} else if (event instanceof UndoEvent) {
			this.mastermind.undo();
		} else if (event instanceof RedoEvent) {
			this.mastermind.redo();
		} else if (event instanceof NewGameEvent) {
			this.mastermind.resume();
			this.play();
		}
	}

	public static void main(String[] args) {
		new MastermindController().play();
	}

}
