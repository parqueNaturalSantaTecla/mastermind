package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.events.UpdateGameEvent;
import santaTecla.utils.Observed;

public class Game extends Observed {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	public Game(SecretCombination secretCombination) {
		this.secretCombination = secretCombination;
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
		this.attempts++;
	}

	public void addResult(Result result) {
		this.results.add(result);
		this.notify(new UpdateGameEvent());
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

	boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}

	boolean isWinner() {
		if (this.attempts == 0) {
			return false;
		}
		return this.results.get(this.attempts - 1).isWinner();
	}

	public int getAttempts() {
		return this.attempts;
	}

	SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	public Result getResult() {
		return this.secretCombination.getResult(this.proposedCombinations.get(this.proposedCombinations.size() - 1));
	}
	
	public List<ProposedCombination> getProposedCombinations(){
		return this.proposedCombinations;
	}
	
	public List<Result> getResults(){
		return this.results;
	}

}
