package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int turn;

	Memento(int turn) {
		this.turn = turn;
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
	}

	void set(ProposedCombination proposedCombination, Result result) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(result);
	}
	
	ProposedCombination getProposedCombination(int position){
		return this.proposedCombinations.get(position);
	}
	
	Result getResult(int position){
		return this.results.get(position);
	}
	
	int getSize() {
		return proposedCombinations.size();
	}
	
	int getTurn(){
		return this.turn;
	}
	
	public String toString(){
		String string = ""+this.getTurn()+", ";
		for (int i=0; i<this.getSize();i++) {
				string += this.proposedCombinations.get(i).getColors().toString()+", ";
				string += this.results.get(i).toString();
		}
		return string;
	}

}
