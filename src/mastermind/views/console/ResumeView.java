package mastermind.views.console;

import mastermind.controllers.ResumeController;
import mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

class ResumeView {
	
	private ResumeController resumeController;

	ResumeView(ResumeController resumeController) {
		this.resumeController = resumeController;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (newGame) {
			this.resumeController.clearGame();			
		}
		return newGame;
	}

}
