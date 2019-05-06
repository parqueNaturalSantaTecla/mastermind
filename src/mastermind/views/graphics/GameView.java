package mastermind.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.views.MessageView;
import mastermind.views.graphics.ProposedCombinationView;
import mastermind.views.graphics.SecretCombinationView;

@SuppressWarnings("serial")
class GameView extends JFrame {

	private static final String GAME_OVER = "Game Over";
	
	private Game game;

	private SecretCombinationView secretCombinationView;

	private ProposedCombinationsView proposedCombinationsView;

	private ProposalCombinationView proposalCombinationView;

	GameView(Game game) {
		super(MessageView.TITLE.getMessage());
		this.game = game;
		this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	void start() {
		this.clear();
		this.secretCombinationView = new SecretCombinationView();
		this.getContentPane().add(this.secretCombinationView, new Constraints(0, 0, 3, 1));
		this.proposedCombinationsView = new ProposedCombinationsView(this.game);
		this.getContentPane().add(this.proposedCombinationsView, new Constraints(0, 1, 3, 10));
		this.proposalCombinationView = new ProposalCombinationView(this.getRootPane());
		this.getContentPane().add(this.proposalCombinationView, new Constraints(0, 11, 3, 1));
		this.setVisible(true);
	}

	boolean propose() {
		ProposedCombination proposedCombination = new ProposedCombination();
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
		do {
			System.out.println("");
			if (this.proposalCombinationView.getCharacters() != null) {
				proposedCombinationView.read(this.proposalCombinationView.getCharacters());		
				if (!proposedCombinationView.isValid()) {
					this.proposalCombinationView.resetCharacters();
				}		
			}
		} while (this.proposalCombinationView.getCharacters() == null);
		this.game.addProposedCombination(proposedCombination);
		this.proposalCombinationView.resetCharacters();
		this.proposedCombinationsView.add();
		this.setVisible(true);
		return this.drawGameOver();
	}

	private boolean drawGameOver() {
		if (this.game.isWinner() || this.game.isLooser()) {
			String message = "";
			if (this.game.isWinner()) {
				message = MessageView.WINNER.getMessage();
			} else {
				message = MessageView.LOOSER.getMessage();
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
