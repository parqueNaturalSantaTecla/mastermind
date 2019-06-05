package mastermind.views;

import mastermind.controllers.ResumeController;
import mastermind.utils.YesNoDialog;
import mastermind.views.menus.MessageView;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}
	
}
