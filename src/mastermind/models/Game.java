package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Combination;

public class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int turn;

	public Game() {
		this.clear();
	}

	public void clear() {
		secretCombination = new SecretCombination();
		proposedCombinations = new ArrayList<ProposedCombination>();
		results = new ArrayList<Result>();
		turn = 0;
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public void proposeCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.turn++;
	}

	public int[][][] getCodes() {
		int[][][] codes = new int[this.turn][2][];
		for (int i = 0; i < codes.length; i++) {
			codes[i][0] = this.proposedCombinations.get(i).getCodes();
			codes[i][1] = this.results.get(i).getCodes();
		}
		return codes;
	}

	public boolean isGameOver() {
		return this.results.get(this.turn-1).isWinner() || this.turn == Game.MAX_LONG;
	}

}
