package mastermind.views;

import mastermind.controllers.StartController;

public class StartView extends WithConsoleView {
	
	private static final String TITTLE = "--------- MASTERMIND ---------";
	
	public void interact(StartController startController) {
		startController.start();
		this.console.write(StartView.TITTLE);
		new SecretCombinationView().writeln(startController.getWidth());
	}

}
