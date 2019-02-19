package mastermind.views.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import mastermind.controllers.ProposalController;
import mastermind.controllers.StartController;
import mastermind.views.graphics.ErrorView;
import mastermind.views.graphics.ProposedCombinationView;
import mastermind.views.graphics.ResultView;
import mastermind.views.graphics.SecretCombinationView;

@SuppressWarnings("serial")
public class GameView extends JFrame{
	
	private static String TITLE = "MASTERMIND";
	private JPanel[] arrayPane;
	private JSplitPane splitPaneContent; 
	private JSplitPane splitPaneSecundary;
	
	public GameView () {
		super(TITLE);
		arrayPane = new JPanel[3];
		for(int i=0;i<3;i++) {
			arrayPane[i] = new JPanel();
		}		
		splitPaneSecundary = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, arrayPane[1],arrayPane[2]);
		splitPaneContent = new JSplitPane (JSplitPane.VERTICAL_SPLIT, arrayPane[0], splitPaneSecundary);
		this.getContentPane().add(splitPaneContent);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void interact(StartController startController) {
		startController.start();
		this.arrayPane[0].add(new SecretCombinationView(startController.getWidth()));
		this.arrayPane[1].add(new ProposedCombinationView());
		this.arrayPane[2].add(new ProposedCombinationView());
		this.setVisible(true);
	}
	
	public void interact(ProposalController proposalController) {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read();
			error = proposalController.proposeCombination(codes);
			if (error != ProposalController.NO_ERROR) {
				new ErrorView(error);
			}
		} while (error != ProposalController.NO_ERROR);
		int[][][] allCodes = proposalController.getAllCodes();
		for (int i = 0; i < allCodes.length; i++) {
			new ProposedCombinationView().draw(allCodes[i][0]);
			new ResultView(allCodes[i][1]);
		}
	}

}
