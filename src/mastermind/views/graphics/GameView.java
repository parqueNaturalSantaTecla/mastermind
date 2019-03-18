package mastermind.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mastermind.controllers.Controller;
import mastermind.controllers.ProposalController;
import mastermind.views.Error;
import mastermind.views.Message;
import mastermind.views.graphics.ProposedCombinationView;
import mastermind.views.graphics.SecretCombinationView;

@SuppressWarnings("serial")
class GameView extends JFrame {
	
	private static final String GAME_OVER = "Game Over";

	private SecretCombinationView secretCombinationView;

	private ProposedCombinationsView proposedCombinationsView;

	private ProposalCombinationView proposalCombinationView;

	GameView() {
		super(Message.TITLE.getMessage());
		this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	void start() {
		this.clear();
		this.secretCombinationView = new SecretCombinationView(Controller.getWidth());
		this.getContentPane().add(this.secretCombinationView, new Constraints(0, 0, 3, 1));
		this.proposedCombinationsView = new ProposedCombinationsView();
		this.getContentPane().add(this.proposedCombinationsView, new Constraints(0, 1, 3, 10));
		this.proposalCombinationView = new ProposalCombinationView(this.getRootPane());
		this.getContentPane().add(this.proposalCombinationView, new Constraints(0, 11, 3, 1));
		this.setVisible(true);
	}

	boolean propose(ProposalController proposalController) {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read(this.proposalCombinationView.getCharacters());
			error = proposalController.proposeCombination(codes);
			if (error != Controller.NO_ERROR && this.proposalCombinationView.getCharacters() != "") {
				JOptionPane.showMessageDialog(null, Error.values()[error].getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
				error = Controller.NO_ERROR;
				this.proposalCombinationView.resetCharacters();
			}
		} while (error != Controller.NO_ERROR || this.proposalCombinationView.getCharacters() == "");
		this.proposalCombinationView.resetCharacters();
		this.proposedCombinationsView.add(proposalController);
		this.setVisible(true);
		return this.drawGameOver(proposalController);
	}

	private boolean drawGameOver(ProposalController proposalController) {
		if (proposalController.isWinner() || proposalController.isLooser()) {
			String message = "";
			if (proposalController.isWinner()) {
				message = Message.WINNER.getMessage();
			} else {
				message = Message.LOOSER.getMessage();
			}
			JOptionPane.showMessageDialog(null, message, GameView.GAME_OVER, JOptionPane.WARNING_MESSAGE);
			return true;
		}
		return false;
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
