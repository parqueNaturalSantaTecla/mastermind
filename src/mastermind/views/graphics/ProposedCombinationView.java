package mastermind.views.graphics;

import java.util.List;

import javax.swing.JLabel;

import mastermind.controllers.ProposalController;
import mastermind.types.Color;
import mastermind.views.ColorView;

@SuppressWarnings("serial")
class ProposedCombinationView extends JLabel {

	public static final int ERROR_CODE = -1;
	
	private ProposalController proposalController;

	ProposedCombinationView(ProposalController proposalController) {
		this.proposalController = proposalController;
		String initials = "";
		for (Color color : this.proposalController.getColors(this.proposalController.getAttempts())) {
			initials += new ColorView(color).getInitial();
		}
		this.setText(initials);
	}

	ProposedCombinationView() {
	}

	List<Color> read(String characters) {
		int[] codes = new int[characters.length()];
		for (int i=0; i<characters.length(); i++) {
			ColorView colorView = ColorView.getInstance(characters.charAt(i));
			if (colorView == null) {
				codes[i] = ProposedCombinationView.ERROR_CODE;
			} else {
				codes[i] = colorView.ordinal();
			}
		}
		return codes;
	}

}
