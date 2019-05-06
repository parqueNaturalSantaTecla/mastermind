package mastermind.views.graphics;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import mastermind.models.Color;
import mastermind.models.Combination;
import mastermind.models.Error;
import mastermind.models.ProposedCombination;
import mastermind.views.ColorView;
import mastermind.views.ErrorView;

@SuppressWarnings("serial")
class ProposedCombinationView extends JLabel {

	private ProposedCombination proposedCombination;

	private Error error;

	ProposedCombinationView(ProposedCombination proposedCombination) {
		this.proposedCombination = proposedCombination;
		String initials = "";
		for (Color color : proposedCombination.getColors()) {
			initials += ColorView.INITIALS[color.ordinal()];
		}
		this.setText(initials);
	}

	ProposedCombinationView() {
	}

	void read(String characters) {
		this.error = null;
		if (characters.length() != Combination.getWidth()) {
			this.error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < characters.length(); i++) {
				Color color = ColorView.getInstance(characters.charAt(i));
				if (color == null) {
					this.error = Error.WRONG_CHARACTERS;
				} else {
					if (this.proposedCombination.getColors().contains(color)) {
						this.error = Error.DUPLICATED;
					} else {
						this.proposedCombination.getColors().add(color);
					}
				}
			}
		}
		if (this.error != null) {
			JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[this.error.ordinal()], "ERROR",
					JOptionPane.WARNING_MESSAGE);
			this.proposedCombination.getColors().clear();
		}
	}

	public boolean isValid() {
		return this.error == null;
	}

}
