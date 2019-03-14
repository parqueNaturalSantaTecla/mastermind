package mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
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

	public void proposeCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.turn++;
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

	public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.turn + "\n");
			this.secretCombination.save(fileWriter);
			for (int i = 0; i < this.turn; i++) {
				this.proposedCombinations.get(i).save(fileWriter);
				this.results.get(i).save(fileWriter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			this.turn = Integer.parseInt(bufferedReader.readLine());
			this.secretCombination.load(bufferedReader);
			for (int i = 0; i < this.turn; i++) {
				ProposedCombination proposedCombination = new ProposedCombination();
				proposedCombination.load(bufferedReader);
				this.proposedCombinations.add(proposedCombination);
				Result result = new Result();
				result.load(bufferedReader);
				this.results.add(result);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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

	public int[][][] getCodes() {
		int[][][] codes = new int[this.turn][2][];
		for (int i = 0; i < codes.length; i++) {
			codes[i][0] = this.proposedCombinations.get(i).getCodes();
			codes[i][1] = this.results.get(i).getCodes();
		}
		return codes;
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public int getTurn() {
		return this.turn;
	}

	@Override
	public String toString() {
		return "Game [secretCombination=" + secretCombination + ", proposedCombinations=" + proposedCombinations
				+ ", results=" + results + ", turn=" + turn + "]";
	}

}
