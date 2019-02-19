package mastermind.views.graphics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SecretCombinationView extends JPanel{
	
	private static final String HIDDEN = "*";
	private JLabel[] labelArray;
	
	public SecretCombinationView(int length) {
		super();
		this.setLayout(new GridBagLayout());
		labelArray = new JLabel[2];
		String text = "";
		for (int i = 0; i < length; i++) {
			text += SecretCombinationView.HIDDEN;
		}
		labelArray[0] = new JLabel("COMBINACIÓN SECRETA:");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		this.add (labelArray[0], constraints);
		labelArray[1] = new JLabel(text);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		this.add (labelArray[1], constraints);
		this.setVisible(true);
	}
}
