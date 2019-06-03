package mastermind.views.graphics;

import mastermind.controllers.Logic;
import mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(Logic logic) {
		super(logic);
		this.gameView = new GameView(logic);
	}

	@Override
	protected void start() {
		this.gameView.start();
	}

	@Override
	protected boolean propose() {
		return this.gameView.propose();
	}

	@Override
	protected boolean isNewGame() {
		ResumeDialog resumeDialog = new ResumeDialog();
		if (resumeDialog.isNewGame()) {
			this.logic.clearGame();
			this.gameView = new GameView(this.logic);
			return true;
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
			return false;
		}
	}

}
