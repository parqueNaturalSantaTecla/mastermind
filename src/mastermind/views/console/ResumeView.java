package mastermind.views.console;

import mastermind.controllers.ResumeController;
import mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read(MessageView.RESUME.getMessage()));
	}
	
}
