package mastermind.views.graphics;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(StartController startController, ProposalController proposalController, ResumeController resumeController) {
		super(startController, proposalController, resumeController);
		this.gameView = new GameView();
	}

	@Override
	protected void start() {
		this.gameView.start(this.startController);
	}

	@Override
	protected boolean propose() {
		return this.gameView.propose(this.proposalController);
	}

	@Override
	protected boolean resume() {
		ResumeDialog resumeDialog = new ResumeDialog();
		this.resumeController.resume(resumeDialog.isResumed());
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
