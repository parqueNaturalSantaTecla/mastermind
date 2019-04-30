package mastermind.views.graphics;

import mastermind.models.Game;
import mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(Game game) {
		super(game);
		this.gameView = new GameView(this.game);
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
	protected boolean resume() {
		ResumeDialog resumeDialog = new ResumeDialog();
		boolean resume = resumeDialog.isResumed();
		if (resume) {
			this.game.clear();
			this.gameView = new GameView(this.game);
			return true;
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
			return false;
		}
	}

}
