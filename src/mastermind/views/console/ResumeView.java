package mastermind.views.console;

import mastermind.controllers.Logic;
import mastermind.utils.YesNoDialog;
import mastermind.views.Message;

class ResumeView {

	boolean interact(Logic logic) {
		boolean resume = new YesNoDialog().read(Message.RESUME.getMessage());
		logic.resume(resume);
		return resume;
	}

}
