package mastermind.views;

import santaTecla.utils.YesNoDialog;

public class ResumeView {

	public Boolean write() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}

}
