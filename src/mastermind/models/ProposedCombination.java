package mastermind.models;

public class ProposedCombination extends Combination {

	public static ProposedCombination getInstance(int[] codes) {
		if (codes.length != Combination.getWidth()) {
			return null;
		}
		ProposedCombination proposedCombination = new ProposedCombination();
		for(int code : codes) {
			proposedCombination.colors.add(Color.getInstance(code));
		}
		return proposedCombination;
	}
	
	public int[] getCodes() {
		int[] codes = new int[Combination.getWidth()];
		for(int i=0; i<codes.length; i++) {
			codes[i] = this.colors.get(i).ordinal();
		}
		return codes;
	}
	
	public boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	public boolean contains(Color color) {
		for (int i=0; i<this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}

	public boolean isDuplicated() {
		boolean repeat = false;
		for(int i=0; i<Combination.getWidth()-1; i++) {
			for(int j=i+1; j<Combination.getWidth(); j++) {
				repeat = contains(this.colors.get(i),j);
				if (repeat) {
					return true;
				}
			}
		}
		return false;
	}

}
