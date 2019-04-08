package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.events.UpdateGameEvent;
import mastermind.utils.Observed;

public class Game extends Observed {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int turn;

	public Game(SecretCombination secretCombination) {
		this.secretCombination = secretCombination;
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.turn = 0;
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.turn = 0;
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
		this.turn++;
	}

	public void addResult(Result result) {
		this.results.add(result);
		this.notify(new UpdateGameEvent());
	}

	public Memento createMemento() {
		Memento memento = new Memento(this.turn);
		for (int i = 0; i < this.proposedCombinations.size(); i++) {
			memento.set(this.proposedCombinations.get(i).copy(), this.results.get(i).copy());
		}
		return memento;
	}

	public void set(Memento memento) {
		this.turn = memento.getTurn();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		for (int i = 0; i < memento.getSize(); i++) {
			this.proposedCombinations.add(memento.getProposedCombination(i).copy());
			this.results.add(memento.getResult(i).copy());
		}
	}

	public boolean isLooser() {
		return this.turn == Game.MAX_LONG;
	}

	public boolean isWinner() {
		if (this.turn == 0) {
			return false;
		}
		return this.results.get(this.turn - 1).isWinner();
	}

	public int getTurn() {
		return this.turn;
	}

	public SecretCombination getSecretCombination() {
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
