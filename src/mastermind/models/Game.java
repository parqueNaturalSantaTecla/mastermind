package mastermind.models;

import java.util.ArrayList;
import java.util.List;
import mastermind.models.Combination;
import mastermind.types.Color;

public class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	public Game() {
		this.secretCombination = new SecretCombination();
		this.clear();
	}

	void clear() {
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}

	Memento createMemento() {
		Memento memento = new Memento(this.attempts);
		for (int i = 0; i < this.proposedCombinations.size(); i++) {
			memento.set(this.proposedCombinations.get(i).copy(), this.results.get(i).copy());
		}
		return memento;
	}

	void set(Memento memento) {
		this.attempts = memento.getAttempts();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		for (int i = 0; i < memento.getSize(); i++) {
			this.proposedCombinations.add(memento.getProposedCombination(i).copy());
			this.results.add(memento.getResult(i).copy());
		}
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
	}

	public void addResult(Result result) {
		this.results.add(result);
	}

	boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}

	boolean isWinner() {
		if (this.attempts == 0) {
			return false;
		}
		return this.results.get(this.attempts - 1).isWinner();
	}

	int getWidth() {
		return Combination.getWidth();
	}

	public int getAttempts() {
		return this.attempts;
	}

	List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	int getWhites(int position) {
		return this.results.get(position).getWhites();
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
				+ ", results=" + results + ", attempts=" + attempts + "]";
	}

}
