package mastermind.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;
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

	void start(Game game) {
		this.clear();
		this.secretCombinationView = new SecretCombinationView(game.getWidth());
		this.getContentPane().add(this.secretCombinationView, new Constraints(0, 0, 3, 1));
		this.proposedCombinationsView = new ProposedCombinationsView();
		this.getContentPane().add(this.proposedCombinationsView, new Constraints(0, 1, 3, 10));
		this.proposalCombinationView = new ProposalCombinationView(this.getRootPane());
		this.getContentPane().add(this.proposalCombinationView, new Constraints(0, 11, 3, 1));
		this.setVisible(true);
	}

	boolean propose(Game game) {
		int error;
		do {
			int[] codes = new ProposedCombinationView().read(this.proposalCombinationView.getCharacters());
			error = this.proposeCombination(codes, game);
			if (error != Game.NO_ERROR && this.proposalCombinationView.getCharacters() != "") {
				JOptionPane.showMessageDialog(null, ErrorView.values()[error].getMessage(), "ERROR",
						JOptionPane.WARNING_MESSAGE);
				error = Game.NO_ERROR;
				this.proposalCombinationView.resetCharacters();
			}
		} while (error != Game.NO_ERROR || this.proposalCombinationView.getCharacters() == "");
		this.proposalCombinationView.resetCharacters();
		this.proposedCombinationsView.add(game);
		this.setVisible(true);
		return this.drawGameOver(game);
	}

	private boolean drawGameOver(Game game) {
		if (game.isWinner() || game.isLooser()) {
			String message = "";
			if (game.isWinner()) {
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

	private int proposeCombination(int[] codes, Game game) {
		mastermind.models.Error error = ProposedCombination.isValid(codes);
		if (error != null) {
			return error.ordinal();
		}
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		game.addProposedCombination(proposedCombination);
		return Game.NO_ERROR;
	}

}
