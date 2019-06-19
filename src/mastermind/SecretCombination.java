package mastermind;

import java.util.Random;

class SecretCombination extends Combination {

	SecretCombination() {
		Random random;
		for (int i = 0; i < this.colors.length; i++) {
			random = new Random(System.currentTimeMillis());
			this.colors[i] = Color.getInstance(random.nextInt(Color.length()));
		}
		this.shuffleArray(this.colors);
	}

	Result getResult(ProposedCombination proposedCombination) {
		int blacks = 0;
		for (int i = 0; i < this.colors.length; i++) {
			if (proposedCombination.contains(this.colors[i], i)) {
				blacks++;
			}
		}
		int whites = 0;
		for (Color color : this.colors) {
			if (proposedCombination.contains(color)) {
				whites++;
			}
		}
		return new Result(blacks, whites - blacks);
	}

	void writeln() {
		for (int i = 0; i < Combination.getWidth(); i++) {
			Message.SECRET.write();
		}
		this.console.writeln();
	}

	void shuffleArray(Color[] array) {
		Random random = new Random(System.currentTimeMillis());
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			Color color = array[index];
			array[index] = array[i];
			array[i] = color;
		}
	}

}
