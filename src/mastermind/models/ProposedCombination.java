package mastermind.models;

public class ProposedCombination extends Combination {

	public static Error isValid(Color[] colors) {
		if (colors.length != Combination.getWidth()) {
			return Error.WRONG_LENGTH;
		}
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] == null) {
				return Error.WRONG_CHARACTERS;
			}
			for (int j = i + 1; j < colors.length; j++) {
				if (colors[i] == colors[j]) {
					return Error.DUPLICATED;
				}
			}
		}
		return null;
	}

	public void set(Color[] colors) {
		for (Color color: colors) {
			this.colors.add(color);			
		}
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

	public ProposedCombination copy() {
		ProposedCombination proposedCombination = new ProposedCombination();
		for (Color color : this.colors) {
			proposedCombination.colors.add(color);
		}
		return proposedCombination;
	}

}
