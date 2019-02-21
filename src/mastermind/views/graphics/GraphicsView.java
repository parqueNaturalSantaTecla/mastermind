package mastermind.views.graphics;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class GraphicsView extends View {
	
	GameView gameView;
	ContinueDialog continueDialog;
	
	public GraphicsView() {
		gameView = new GameView();
	}
	
	@Override
	public void visit(StartController startController) {
		gameView.interact(startController);		
	}

	@Override
	public void visit(ProposalController proposalController) {
		gameView.interact(proposalController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		continueDialog = new ContinueDialog();
		continueDialog.interact(resumeController);
	}
	
}
