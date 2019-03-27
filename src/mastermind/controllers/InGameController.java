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
		this.gameView.setTurn(this.session.getTurn());
		this.gameView.setWidth(this.getWidth());
		this.gameView.setAllCodes(this.session.getCodes());
		this.gameView.writeGame();
		if (this.session.isWinner()) {
			this.gameView.writeWinner();
		} else if (this.session.isLooser()) {
			this.gameView.writeLooser();
		}
	}

	protected abstract void inGameControl();

}
