package mastermind.views.graphics;

import mastermind.controllers.Logic;
import mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(Logic logic) {
		super(logic);
		this.gameView = new GameView();
	}

	@Override
	protected void start() {
		this.gameView.start(this.logic);
	}

	@Override
	protected boolean propose() {
		return this.gameView.propose(this.logic);
	}

	@Override
	protected boolean resume() {
		ResumeDialog resumeDialog = new ResumeDialog();
		this.logic.resume(resumeDialog.isResumed());
		if (resumeDialog.isResumed()) {
			this.gameView = new GameView();
			return true;
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
			return false;
		}
	}

}
