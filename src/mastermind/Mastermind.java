package mastermind;

import santaTecla.utils.WithConsoleModel;
import santaTecla.utils.YesNoDialog;

public class Mastermind extends WithConsoleModel {

	private Game game;

	private Mastermind() {
		this.game = new Game();
	}

	public void play() {
		boolean resume;
		do {
			this.console.writeln(Message.TITLE.getMessage());
			this.game.getSecretCombination().writeln();
			boolean finished = false;
			do {
				int error;
				do {
					int[] codes = new ProposedCombination().read();
					error = this.game.proposeCombination(codes);
					if (error != Game.NO_ERROR) {
						this.console.writeln(Error.values()[error].getMessage());
					}
				} while (error != Game.NO_ERROR);
				this.console.writeln();
				this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + game.getTurn()));
				this.game.getSecretCombination().writeln();
				int[][][] allCodes = this.game.getCodes();
				for (int i = 0; i < allCodes.length; i++) {
					new ProposedCombination().write(allCodes[i][0]);
					new Result(allCodes[i][1][0], allCodes[i][1][1]).writeln();
				}
				if (this.game.isWinner()) {
					this.console.writeln(Message.WINNER.getMessage());
					finished = true;
				} else if (this.game.isLooser()) {
					this.console.writeln(Message.LOOSER.getMessage());
					finished = true;
				}
			} while (!finished);
			resume = new YesNoDialog().read(Message.RESUME.getMessage());
			if (resume) {
				this.game.clear();
			}
		} while (resume);
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
