package mastermind.models;

import java.util.ArrayList;

import mastermind.mvcUtils.UpdateGameEvent;
import mastermind.mvcUtils.Observed;

public class Game extends Observed{

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private ArrayList<ProposedCombination> proposedCombinations;

	private ArrayList<Result> results;

	private int turn;
	//
	// public Game() {
	// this.clear();
	// }

	public Game(SecretCombination secretCombination) {
		this.secretCombination = secretCombination;
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.turn = 0;
	}

	public SecretCombination getSecretCombination() {
		return this.secretCombination;
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
		this.notify(new UpdateGameEvent());
	}

	public ProposedCombination getProposedCombination(int position) {
		return this.proposedCombinations.get(position);
	}

	public Result getResultCombination(int position) {
		return this.results.get(position);
	}

	public int getTurn() {
		return this.turn;
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

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.turn++;
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.turn = 0;
	}
	//
	// public void proposeCombination(ProposedCombination proposedCombination) {
	// this.proposedCombinations.add(proposedCombination);
	// this.results.add(this.secretCombination.getResult(proposedCombination));
	// this.turn++;
	// }
	//

	public Result getResult() {
		return this.secretCombination.getResult(this.proposedCombinations.get(this.proposedCombinations.size()-1));
	}

	public void addResult(Result result) {
		this.results.add(result);
		this.notify(new UpdateGameEvent());
	}

}
