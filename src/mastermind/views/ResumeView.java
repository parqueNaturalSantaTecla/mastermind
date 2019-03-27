package mastermind.views;

import mastermind.utils.YesNoDialog;

public class ResumeView {

	public Boolean write() {
		return new YesNoDialog().read(Message.RESUME.getMessage());
	}

}
