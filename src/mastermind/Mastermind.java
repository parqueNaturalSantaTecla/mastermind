package mastermind;

import java.util.ArrayList;
import java.util.List;
import mastermind.utils.WithConsoleModel;
import mastermind.utils.YesNoDialog;

public class Mastermind extends WithConsoleModel {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	private Mastermind() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	private void play() {
		Message.TITLE.write();
		this.secretCombination.writeln();
		boolean finished = false;
		do {
			ProposedCombination proposedCombination = new ProposedCombination();
			proposedCombination.read();
			this.proposedCombinations.add(proposedCombination);
			this.results.add(this.secretCombination.getResult(proposedCombination));
			this.attempts++;
			this.console.writeln();
			Message.TURN.write(this.attempts);
			this.secretCombination.writeln();
			for (int i = 0; i < this.attempts; i++) {
				this.proposedCombinations.get(i).write();
				this.results.get(i).writeln();
			}
			if (this.results.get(this.attempts - 1).isWinner()) {
				Message.WINNER.write();
				finished = true;
			} else if (this.attempts == Mastermind.MAX_LONG) {
				Message.LOOSER.write();
				finished = true;
			}
		} while (!finished);
		Message.RESUME.write();
		boolean resume = new YesNoDialog().read();
		if (resume) {
			new Mastermind().play();
		}
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
