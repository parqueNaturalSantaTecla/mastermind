package mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mastermind.models.Combination;
import mastermind.types.Color;

class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	Game() {
		this.clear();
	}

	void clear() {
		this.secretCombination = new SecretCombination();
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

	boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}
	
	boolean isWinner() {
		if (this.attempts == 0) {
			return false;
		}
		return this.results.get(this.attempts-1).isWinner();
	}

	int getAttempts() {
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

	int getWidth() {
		return Combination.getWidth();
	}

	void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.attempts + "\n");
			this.secretCombination.save(fileWriter);
			for (int i = 0; i < this.attempts; i++) {
				this.proposedCombinations.get(i).save(fileWriter);
				this.results.get(i).save(fileWriter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(BufferedReader bufferedReader) {
		try {
			this.attempts = Integer.parseInt(bufferedReader.readLine());
			this.secretCombination.load(bufferedReader);
			for (int i = 0; i < this.attempts; i++) {
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

}
