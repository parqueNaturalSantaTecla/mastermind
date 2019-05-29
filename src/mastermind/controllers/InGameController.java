package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.GameView;

public abstract class InGameController extends Controller {

	private GameView gameView;

	InGameController(Session session) {
		super(session);
		this.gameView = new GameView();
	}

	@Override
	public void control() {
		this.inGameControl();
		this.gameView.setAttempts(this.session.getAttempts());
		this.gameView.setWidth(this.getWidth());
		this.gameView.clearAllColors();
		this.gameView.clearAllResults();
		for(int i=0; i<this.session.getAttempts(); i++) {
			this.gameView.setAllColors(this.session.getColors(i));
			this.gameView.setAllResults(this.session.getBlacks(i),this.session.getWhites(i));
		}
		this.gameView.writeGame();
		if (this.session.isWinner()) {
			this.gameView.writeWinner();
		} else if (this.session.isLooser()) {
			this.gameView.writeLooser();
		}
	}

	protected abstract void inGameControl();

}
