package mastermind.views.graphics;

import mastermind.controllers.Controller;
import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}

	@Override
	public void interact(Controller controller) {
		if (controller instanceof StartController) {
			this.gameView.interact((StartController) controller);
		} else {
			if (controller instanceof ProposalController) {
				this.gameView.interact((ProposalController) controller);
			} else {
				ResumeDialog resumeDialog = new ResumeDialog();
				((ResumeController) controller).clearGame(resumeDialog.isNewGame());
				if (resumeDialog.isNewGame()) {
					this.gameView = new GameView();
				} else {
					this.gameView.setVisible(false);
					System.exit(0);
				}
			}
		}
	}

}
