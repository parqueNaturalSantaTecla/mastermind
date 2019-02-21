package mastermind.views.graphics;

import javax.swing.JOptionPane;

import mastermind.controllers.ResumeController;

public class ContinueDialog {

	private static final String MESSAGE = "¿Desea continuar?";

	public void interact(ResumeController resumeController) {
		boolean resume = (JOptionPane.showConfirmDialog(null, MESSAGE, "MasterMind",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
		resumeController.resume(resume);
		if (!resume) {
			System.exit(0);
		}
	}

}
