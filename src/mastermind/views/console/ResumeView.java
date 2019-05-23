package mastermind.views.console;

import mastermind.controllers.ResumeController;
import mastermind.utils.YesNoDialog;
import mastermind.views.MessageView;

class ResumeView {
	
	private ResumeController resumeController;

	ResumeView(ResumeController resumeController) {
		this.resumeController = resumeController;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		this.resumeController.isNewGame(newGame);
		return newGame;
	}

}
