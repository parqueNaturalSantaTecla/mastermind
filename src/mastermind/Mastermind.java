package mastermind;

import santaTecla.utils.WithConsoleModel;
import santaTecla.utils.YesNoDialog;

public class Mastermind extends WithConsoleModel {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private ProposedCombination[] proposedCombinations;

	private Result[] results;

	private int attempts;

	private Mastermind() {
		this.clear();
	}

	private void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ProposedCombination[Mastermind.MAX_LONG];
		this.results = new Result[Mastermind.MAX_LONG];
		this.attempts = 0;
	}

	private void play() {
		boolean newGame;
		do {
			Message.TITLE.writeln();
			this.secretCombination.writeln();
			boolean finished = false;
			do {
				ProposedCombination proposedCombination = new ProposedCombination();
				proposedCombination.read();
				boolean added = false;
				int i = 0;
				while (!added && i < this.proposedCombinations.length) {
					if (this.proposedCombinations[i] == null) {
						this.proposedCombinations[i] = proposedCombination;
						this.results[i] = this.secretCombination.getResult(proposedCombination);
						added = true;
					}
					i++;
				}
				this.attempts++;
				this.console.writeln();
				Message.ATTEMPTS.writeln(this.attempts);
				this.secretCombination.writeln();
				for (i = 0; i < this.attempts; i++) {
					this.proposedCombinations[i].write();
					this.results[i].writeln();
				}
				if (this.results[this.attempts - 1].isWinner()) {
					Message.WINNER.writeln();
					finished = true;
				} else if (this.attempts == Mastermind.MAX_LONG) {
					Message.LOOSER.writeln();
					finished = true;
				}
			} while (!finished);
			Message.RESUME.write();
			newGame = new YesNoDialog().read();
			if (newGame) {
				this.clear();
			}
		} while (newGame);
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
