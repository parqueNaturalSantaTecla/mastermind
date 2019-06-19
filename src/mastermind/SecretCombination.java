package mastermind;

import java.util.Collections;
import java.util.Random;

class SecretCombination extends Combination {

	SecretCombination() {
		for(Color color: Color.values()) {
			this.colors.add(color);
		}
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < Color.length() - Combination.getWidth(); i++) {
			this.colors.remove(random.nextInt(this.colors.length));
		}
		Collections.shuffle(this.colors);
	}

	Result getResult(ProposedCombination proposedCombination) {
		int blacks = 0;
		for (int i = 0; i < this.colors.length; i++) {
			if (proposedCombination.contains(this.colors.get(i), i)) {
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
	
	void writeln () {
		for (int i = 0; i < Combination.getWidth(); i++) {
			Message.SECRET.write();
		}
		this.console.writeln();
	}

}
