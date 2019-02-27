package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int turn;

	public Memento(int turn) {
		this.turn = turn;
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
	}

	public void set(ProposedCombination proposedCombination, Result result) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(result);
	}
	
	int getTurn(){
		return this.turn;
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

//	@Override
//	public String toString() {
//		String toString = "GameMemento [\ntokenTurn=" + tokenTurn + "\ntokensBoard=\n";
//		for(int i=0; i<tokensBoard.length; i++){
//			for(int j=0; j<tokensBoard[i].length; j++){
//				toString += tokensBoard[i][j] + " ";
//			}
//			toString += "\n";
//		}
//		return toString + "]";
//	}
}
