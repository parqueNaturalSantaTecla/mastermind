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
		Error error;
		do {
			error = null;
			if (characters.length() > Combination.getWidth()) {
				error = Error.WRONG_LENGTH;
			} else {
				for (int i = 0; i < characters.length(); i++) {
					System.out.println("Entra al for");
					Color color = ColorView.getInstance(characters.charAt(i));
					if (color == null) {
						error = Error.WRONG_CHARACTERS;
					} else {
						if (this.proposedCombination.getColors().contains(color)) {
							error = Error.DUPLICATED;
						} else {
							System.out.println("Añade color");
							this.proposedCombination.getColors().add(color);
						}
					}
				}
			}
			if (error != null) {
				JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal()], "ERROR",
						JOptionPane.WARNING_MESSAGE);
				this.proposedCombination.getColors().clear();
			}
		} while (error != null || characters == "");
	}

}
