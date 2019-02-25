package mastermind.views.graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mastermind.views.graphics.ColorView;

@SuppressWarnings("serial")
public class ProposedCombinationView extends JPanel{

	public static final int ERROR_CODE = -1;
	JLabel label;

	public ProposedCombinationView(int[] codes) {
		String initials = "";
		for (int code : codes) {
			initials += ColorView.getInstance(code).getInitial();
		}
		label = new JLabel(initials);
		this.add(label);
	}

	public ProposedCombinationView() {
	}

	public int[] read(String characters) {
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
