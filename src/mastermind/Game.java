package mastermind;

import java.util.ArrayList;
import java.util.List;

class Game {

	static final int NO_ERROR = -1;

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int turn;

	Game() {
		this.clear();
	}

	void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.turn = 0;
	}

	int proposeCombination(int[] codes) {
		Error error = ProposedCombination.isValid(codes);
		if (error != null) {
			return error.ordinal();
		}
		ProposedCombination proposedCombination = ProposedCombination.getInstance(codes);
		this.addCombination(proposedCombination);
		return Game.NO_ERROR;
	}

	private void addCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.turn++;
	}

	int[][][] getCodes() {
		int[][][] codes = new int[this.turn][2][];
		for (int i = 0; i < codes.length; i++) {
			codes[i][0] = this.proposedCombinations.get(i).getCodes();
			codes[i][1] = this.results.get(i).getCodes();
		}
		return codes;
	}

	boolean isLooser() {
		return this.turn == Game.MAX_LONG;
	}
	
	boolean isWinner() {
		return this.results.get(this.turn-1).isWinner();
	}

	int getTurn() {
		return this.turn;
	}

	public SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

}
