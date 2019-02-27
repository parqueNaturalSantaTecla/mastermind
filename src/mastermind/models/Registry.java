package mastermind.models;

import java.util.ArrayList;

public class Registry {
	
	private ArrayList<Memento> mementoList;
	
	private Game game;
	
	private int firstPrevious;
	
	public Registry(Game game) {
		this.game = game;
		this.mementoList = new ArrayList<Memento>();
		this.mementoList.add(firstPrevious, this.game.createMemento());
		this.firstPrevious = 0;
	}

	public void registry() {
		for (int i = 0; i < this.firstPrevious; i++) {
			this.mementoList.remove(0);
		}
		this.firstPrevious = 0;
		this.mementoList.add(this.firstPrevious, this.game.createMemento());
	}

	public void undo(Game game) {
		this.firstPrevious++;
		game.set(this.mementoList.get(this.firstPrevious));
	}

	public void redo(Game game) {
		this.firstPrevious--;
		game.set(this.mementoList.get(this.firstPrevious));
	}

	public boolean undoable() {
		return this.firstPrevious < this.mementoList.size() - 1;
	}

	public boolean redoable() {
		return this.firstPrevious >= 1;
	}

	@Override
	public String toString() {
		String result = "CommandRegistry [\nposition=" + firstPrevious
				+ "\nmementos=";
		for (Memento memento : mementoList) {
			result += "\n" + memento.toString();
		}
		return result + "]";
	}

	public void printMementos() {
		for(int i=0; i<this.mementoList.size();i++) {
			for(int j=0; j<this.mementoList.get(i).getSize(); j++) {
				for(int k=0; k<Combination.getWidth(); k++) {
					System.out.print(this.mementoList.get(i).getProposedCombination(j).colors.get(k));					
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
