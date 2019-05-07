package mastermind.views.graphics;

import javax.swing.JLabel;
import mastermind.views.ColorView;

@SuppressWarnings("serial")
class ProposedCombinationView extends JLabel {

	public static final int ERROR_CODE = -1;

	ProposedCombinationView(int[] codes) {
		String initials = "";
		for (int code : codes) {
			initials += ColorView.getInstance(code).getInitial();
		}
		this.setText(initials);
	}

	ProposedCombinationView() {
	}

	int[] read(String characters) {
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
