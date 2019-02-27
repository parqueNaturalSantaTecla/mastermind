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
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.turn = 0;
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

	public boolean isLooser() {
		return this.turn == Game.MAX_LONG;
	}

	public boolean isWinner() {
		return this.results.get(this.turn - 1).isWinner();
	}

	public int getTurn() {
		return this.turn;
	}

	public Memento createMemento() {
		Memento memento = new Memento(this.turn);
		for (int i = 0; i < this.proposedCombinations.size(); i++) {
			ProposedCombination proposedCombination = new ProposedCombination();
			int[] codes = new int[Combination.getWidth()];
			codes = this.proposedCombinations.get(i).getCodes();
			proposedCombination.setCodes(codes);
			Result result = new Result(this.secretCombination.getResult(proposedCombination).getBlacks(),
					this.secretCombination.getResult(proposedCombination).getWhites());
			memento.set(proposedCombination, result);
		}
		return memento;
	}

	public void set(Memento memento) {
		this.turn = memento.getTurn();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		for (int i = 0; i<memento.getSize(); i++) {
			int[] codes = new int[Combination.getWidth()];
			ProposedCombination proposedCombination = new ProposedCombination();
			codes = memento.getProposedCombination(i).getCodes();
			proposedCombination.setCodes(codes);
//				proposedCombination.colors.add(memento.getProposedCombination(i).colors.get(j));
			this.proposedCombinations.add(proposedCombination);
			Result result = new Result(memento.getResult(i).getBlacks(),memento.getResult(i).getWhites());
			this.results.add(result);			
		}
	}

}
