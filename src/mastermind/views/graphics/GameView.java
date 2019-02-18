package mastermind.views.graphics;

import javax.swing.JFrame;

import mastermind.controllers.ProposalController;
import mastermind.controllers.StartController;

@SuppressWarnings("serial")
public class GameView extends JFrame{
	
	private static String TITLE = "MASTERMIND";
	
	public GameView () {
		super(TITLE);
	}

	public void interact(StartController startController) {
		startController.start();
		this.getContentPane().add(new SecretCombinationView(startController.getWidth()));	
	}
	
	public void interact(ProposalController proposalController) {
		// TODO no decir palabrotas	
	}

}
