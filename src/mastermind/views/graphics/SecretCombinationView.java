package mastermind.views.graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SecretCombinationView extends JPanel{
	
	private static final String HIDDEN = "*";
	private JLabel label;
	
	public SecretCombinationView(int length) {
		super();
		String text = "";
		for (int i = 0; i < length; i++) {
			text += SecretCombinationView.HIDDEN;
		}
		this.label = new JLabel(text);
		this.add(label);
	}
}
