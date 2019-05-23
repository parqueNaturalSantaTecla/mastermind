package mastermind.models;

import java.util.ArrayList;
import java.util.List;

class Memento {

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	Memento(int attempts) {
		this.attempts = attempts;
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
	
	int getAttempts(){
		return this.attempts;
	}

}
