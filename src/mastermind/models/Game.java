package mastermind.models;

import java.util.ArrayList;

import mastermind.mvcUtils.UpdateGameEvent;
import mastermind.mvcUtils.Observed;

public class Game extends Observed {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private ArrayList<ProposedCombination> proposedCombinations;

	private ArrayList<Result> results;

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
		for (ProposedCombination proCom: this.proposedCombinations) {
			System.out.println("ProposedComb Game.addPC "+ proCom.toString());				
		}	
		this.turn++;
	}

	public void addResult(Result result) {
		this.results.add(result);
		for (Result resultAux: this.results) {
			System.out.println("Result Game.addRes "+ resultAux.toString());			
		}
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
		System.out.println("set memento");
		this.turn = memento.getTurn();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		System.out.println("memento size "+memento.getSize());
		for (int i = 0; i < memento.getSize(); i++) {
			this.proposedCombinations.add(memento.getProposedCombination(i).copy());
			System.out.println("PC G.set "+memento.getProposedCombination(i).toString());
			this.results.add(memento.getResult(i).copy());
			System.out.println("Res G.set "+memento.getResult(i).toString());
		}
		this.notify(new UpdateGameEvent());
	}

	public boolean isLooser() {
		return this.turn == Game.MAX_LONG;
	}

	public boolean isWinner() {
		System.out.println("resultados: "+this.results.size());
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

}
