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

	Game() {
		this.clear();
	}

	void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.turn = 0;
	}

	void proposeCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.turn++;
	}

	Memento createMemento() {
		Memento memento = new Memento(this.turn);
		for (int i = 0; i < this.proposedCombinations.size(); i++) {
			memento.set(this.proposedCombinations.get(i).copy(), this.results.get(i).copy());
		}
		return memento;
	}

	void set(Memento memento) {
		this.turn = memento.getTurn();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		for (int i = 0; i < memento.getSize(); i++) {
			this.proposedCombinations.add(memento.getProposedCombination(i).copy());
			this.results.add(memento.getResult(i).copy());
		}
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public void setSecretCombination(int[] codes) {
		this.secretCombination.clearColors();
		for (int i = 0; i < Combination.getWidth(); i++) {
			this.secretCombination.addColor(Color.getInstance(codes[i]));
		}
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
	}

	public void addResult(Result result) {
		this.results.add(result);
	}

	boolean isLooser() {
		return this.turn == Game.MAX_LONG;
	}

	boolean isWinner() {
		if (this.turn == 0) {
			return false;
		}
		return this.results.get(this.turn - 1).isWinner();
	}

	int[][][] getCodes() {
		int[][][] codes = new int[this.turn][2][];
		for (int i = 0; i < codes.length; i++) {
			codes[i][0] = this.proposedCombinations.get(i).getCodes();
			codes[i][1] = this.results.get(i).getCodes();
		}
		return codes;
	}

	int getWidth() {
		return Combination.getWidth();
	}

	public int getTurn() {
		return this.turn;
	}
	
	public int[] getSecretCombinationCodes() {
		return this.secretCombination.getCodes();
	}

	public SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	public ProposedCombination getProposedCombination(int position) {
		return this.proposedCombinations.get(position);
	}

	public Result getResult(int position) {
		return this.results.get(position);
	}

	@Override
	public String toString() {
		return "Game [secretCombination=" + secretCombination + ", proposedCombinations=" + proposedCombinations
				+ ", results=" + results + ", turn=" + turn + "]";
	}

	public int[] getProposedCombinationCodes(int turn) {
		return this.proposedCombinations.get(turn).getCodes();
	}

}
