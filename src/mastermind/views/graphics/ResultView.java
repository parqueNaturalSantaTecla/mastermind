package mastermind.views.graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ResultView extends JPanel {

	private static final String MESSAGES = "-> #blacks negros y #whites blancos";
	private JLabel label;

	public ResultView(int[] results) {
		label = new JLabel(MESSAGES.replaceFirst("#blacks", "" + results[0]).replaceFirst("#whites", "" + results[1]));
		this.add(label);
	}
}
