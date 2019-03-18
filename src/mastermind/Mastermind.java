package mastermind;

import java.util.ArrayList;
import java.util.List;
import mastermind.utils.WithConsoleModel;
import mastermind.utils.YesNoDialog;

public class Mastermind extends WithConsoleModel {

	static final int NO_ERROR = -1;

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int turn;

	private Mastermind() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.turn = 0;
	}

	private void play() {
		this.console.writeln(Message.TITLE.getMessage());
		this.secretCombination.writeln();
		boolean finished = false;
		do {
			int error;
			do {
				int[] codes = new ProposedCombination().read();
				error = this.proposeCombination(codes);
				if (error != Mastermind.NO_ERROR) {
					this.console.writeln(Error.values()[error].getMessage());
				}
			} while (error != Mastermind.NO_ERROR);
			this.console.writeln();
			this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + this.turn));
			this.secretCombination.writeln();
			int[][][] allCodes = this.getCodes();
			for (int i = 0; i < allCodes.length; i++) {
				new ProposedCombination().write(allCodes[i][0]);
				new Result(allCodes[i][1][0], allCodes[i][1][1]).writeln();
			}
			if (this.results.get(this.turn - 1).isWinner()) {
				this.console.writeln(Message.WINNER.getMessage());
				finished = true;
			} else if (this.turn == Mastermind.MAX_LONG) {
				this.console.writeln(Message.LOOSER.getMessage());
				finished = true;
			}
		} while (!finished);
		boolean resume = new YesNoDialog().read(Message.RESUME.getMessage());
		if (resume) {
			new Mastermind().play();
		}
	}

	private int proposeCombination(int[] codes) {
		Error error = ProposedCombination.isValid(codes);
		if (error != null) {
			return error.ordinal();
		}
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.turn++;
		return Mastermind.NO_ERROR;
	}

	private int[][][] getCodes() {
		int[][][] codes = new int[this.turn][2][];
		for (int i = 0; i < codes.length; i++) {
			codes[i][0] = this.proposedCombinations.get(i).getCodes();
			codes[i][1] = this.results.get(i).getCodes();
		}
		return codes;
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
