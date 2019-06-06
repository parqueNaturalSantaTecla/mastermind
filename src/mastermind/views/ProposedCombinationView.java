package mastermind.views;

import mastermind.models.Color;
import mastermind.models.Error;
import mastermind.models.Combination;
import mastermind.models.ProposedCombination;
import santaTecla.utils.WithConsoleView;

class ProposedCombinationView extends WithConsoleView {

	void write(ProposedCombination proposedCombination) {
		for (Color color: proposedCombination.getColors()) {
			new ColorView().write(color);
		}
	}

	void read(ProposedCombination proposedCombination) {
		Error error;
		do {
			error = null;
			MessageView.PROPOSED_COMBINATION.write();
			String characters = this.console.readString();
			if (characters.length() > Combination.getWidth()) {
				error = Error.WRONG_LENGTH;
			} else {
				for (int i = 0; i < characters.length(); i++) {
					Color color = ColorView.getInstance(characters.charAt(i));
					if (color == null) {
						error = Error.WRONG_CHARACTERS;
					} else {
						if (proposedCombination.getColors().contains(color)) {
							error = Error.DUPLICATED;
						} else {
							proposedCombination.getColors().add(color);
						}
					}
				}
			}
			if (error != null) {
				new ErrorView().writeln(error);
				proposedCombination.getColors().clear();
			}
		} while (error != null);
	}

}
