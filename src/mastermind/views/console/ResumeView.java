package mastermind.views.console;

import mastermind.controllers.ResumeController;
import mastermind.utils.YesNoDialog;
import mastermind.views.Message;

class ResumeView {

	boolean interact(ResumeController resumeController) {
		boolean resume = new YesNoDialog().read(Message.RESUME.getMessage());
		resumeController.resume(resume);
		return resume;
	}

}
