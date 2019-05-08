package mastermind.views.graphics;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(StartController startController, ProposalController proposalController, ResumeController resumeController) {
		super(startController, proposalController, resumeController);
		this.gameView = new GameView(startController, proposalController);
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
		this.resumeController.resume(resumeDialog.isNewGame());
		if (resumeDialog.isNewGame()) {
			this.gameView = new GameView(this.startController, this.proposalController);
			return true;
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
			return false;
		}
	}

}
