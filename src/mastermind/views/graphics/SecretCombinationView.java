package mastermind.views.graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SecretCombinationView extends JPanel{
	
	private static final String HIDDEN = "*";
	private JLabel[] labelArray;
	
	public SecretCombinationView(int length) {
		super();
		labelArray = new JLabel[2];
		String text = "";
		for (int i = 0; i < length; i++) {
			text += SecretCombinationView.HIDDEN;
		}
		for(int i=0; i<2;i++) {
			this.labelArray[i] = new JLabel();
			this.add(labelArray[i]);
		}
		this.labelArray[0].setText("COMBINACIÓN SECRETA:");
		this.labelArray[1].setText(text);
		this.setVisible(true);
	}
}
