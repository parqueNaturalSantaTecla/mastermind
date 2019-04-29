package mastermind;

class ProposedCombination extends Combination {
	
	void write() {
		for (Color color: this.colors) {
			color.write();
		}
	}

	void read() {
		Error error;
		do {
			error = null;
			Message.PROPOSED_COMBINATION.write();
			String characters = this.console.readString();
			if (characters.length() != Combination.getWidth()) {
				error = Error.WRONG_LENGTH;
			} else {
				for (int i = 0; i < characters.length(); i++) {
					Color color = Color.getInstance(characters.charAt(i));
					if (color == null) {
						error = Error.WRONG_CHARACTERS;
					} else {
						if (this.colors.contains(color)) {
							error = Error.DUPLICATED;
						} else {
							this.colors.add(color);
						}
					}
				}
			}
			if (error != null) {
				error.writeln();
				this.colors.clear();
			}
		} while (error != null);
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

}
