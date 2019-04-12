package mastermind.views;

import mastermind.utils.YesNoDialog;

public class ResumeView {

	public boolean write() {
		return new YesNoDialog().read(Message.RESUME.getMessage());
	}

}
