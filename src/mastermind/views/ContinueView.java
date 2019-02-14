package mastermind.views;

import mastermind.controllers.ResumeController;
import mastermind.utils.YesNoDialog;

public class ContinueView {

	public void interact(ResumeController continueController) {
		continueController.resume(new YesNoDialog().read("Desea continuar"));
	}
	
}
