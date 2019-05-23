package mastermind.views;

import mastermind.controllers.ResumeController;
import mastermind.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.isNewGame(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}
	
}
