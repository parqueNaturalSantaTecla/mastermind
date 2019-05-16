package mastermind.views.graphics;

import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mastermind.controllers.ProposalController;
import mastermind.controllers.StartController;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.ErrorView;
import mastermind.views.MessageView;
import mastermind.views.graphics.ProposedCombinationView;
import mastermind.views.graphics.SecretCombinationView;

@SuppressWarnings("serial")
class GameView extends JFrame {
	
	private static final String GAME_OVER = "Game Over";

	private SecretCombinationView secretCombinationView;

	private ProposedCombinationsView proposedCombinationsView;

	private ProposalCombinationView proposalCombinationView;

	GameView() {
		super(MessageView.TITLE.getMessage());
		this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	void interact(StartController startController) {
		this.clear();
		startController.start();
		this.secretCombinationView = new SecretCombinationView(startController);
		this.getContentPane().add(this.secretCombinationView, new Constraints(0, 0, 3, 1));
		this.proposedCombinationsView = new ProposedCombinationsView();
		this.getContentPane().add(this.proposedCombinationsView, new Constraints(0, 1, 3, 10));
		this.proposalCombinationView = new ProposalCombinationView(this.getRootPane());
		this.getContentPane().add(this.proposalCombinationView, new Constraints(0, 11, 3, 1));
		this.setVisible(true);
	}

	void interact(ProposalController proposalController) {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView().read(this.proposalCombinationView.getCharacters());
			error = proposalController.addProposedCombination(colors);
			if (error != null && this.proposalCombinationView.getCharacters() != "") {
				JOptionPane.showMessageDialog(null, new ErrorView(error).getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
				error = null;
				this.proposalCombinationView.resetCharacters();
			}
		} while (error != null || this.proposalCombinationView.getCharacters() == "");
		this.proposalCombinationView.resetCharacters();
		this.proposedCombinationsView.add(proposalController);
		this.drawGameOver(proposalController);
		this.setVisible(true);
	}

	private void drawGameOver(ProposalController proposalController) {
		if (proposalController.isWinner() || proposalController.isLooser()) {
			String message = "";
			if (proposalController.isWinner()) {
				message = MessageView.WINNER.getMessage();
			} else {
				message = MessageView.LOOSER.getMessage();
			}
			JOptionPane.showMessageDialog(null, message, GameView.GAME_OVER, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void clear() {
		if (this.secretCombinationView != null) {
			this.secretCombinationView.removeAll();
		}
		if (this.proposedCombinationsView != null) {
			this.proposedCombinationsView.removeAll();
		}
	}

}
