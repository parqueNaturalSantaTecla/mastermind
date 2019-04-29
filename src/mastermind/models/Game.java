package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Combination;

public class Game {

	public static final int NO_ERROR = -1;

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	public Game() {
		this.clear();
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}

//	public int[][][] getCodes() {
//		int[][][] codes = new int[this.turn][2][];
//		for (int i = 0; i < codes.length; i++) {
//			codes[i][0] = this.proposedCombinations.get(i).getCodes();
//			codes[i][1] = this.results.get(i).getCodes();
//		}
//		return codes;
//	}

	public boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}
	
	public boolean isWinner() {
		return this.results.get(this.attempts-1).isWinner();
	}


	public int getAttempts() {
		return this.attempts;
	}

}
