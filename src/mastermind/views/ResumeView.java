package mastermind.views;

import mastermind.utils.YesNoDialog;

public class ResumeView {

	public Boolean write() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}

}
