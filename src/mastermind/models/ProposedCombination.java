package mastermind.models;

public class ProposedCombination extends Combination {

	public static Error isValid(int[] codes) {
		if (codes.length != Combination.getWidth()) {
			return Error.WRONG_LENGTH;
		}
		for (int i = 0; i < codes.length; i++) {
			if (codes[i] == -1) {
				return Error.WRONG_CHARACTERS;
			}
			for (int j = i + 1; j < codes.length; j++) {
				if (codes[i] == codes[j]) {
					return Error.DUPLICATED;
				}
			}
		}
		return null;
	}

	public static ProposedCombination getInstance(int[] codes) {
		assert ProposedCombination.isValid(codes) != null;
		ProposedCombination proposedCombination = new ProposedCombination();
		for (int code : codes) {
			proposedCombination.colors.add(Color.getInstance(code));
		}
		return proposedCombination;
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}

	int[] getCodes() {
		int[] codes = new int[Combination.getWidth()];
		for (int i = 0; i < codes.length; i++) {
			codes[i] = this.colors.get(i).ordinal();
		}
		return codes;
	}
	
	void setCodes(int[] codes) {
		for (int i = 0; i < codes.length; i++) {
			this.colors.add(Color.getInstance(codes[i]));
		}
	}

	public ProposedCombination copy() {
		ProposedCombination proposedCombination = new ProposedCombination();
		for(Color color: this.colors) {
			proposedCombination.colors.add(color);
		}
		return proposedCombination;
	}

	@Override
	public String toString() {
		return "ProposedCombination [colors=" + colors + "]";
	}

}
