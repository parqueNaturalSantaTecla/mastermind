package mastermind.views;

import mastermind.controllers.ResumeController;
import mastermind.utils.YesNoDialog;

public class ResumeView {

	public void interact(ResumeController resumeController) {
		resumeController.resume(new YesNoDialog().read("Desea continuar"));
	}
	
}
