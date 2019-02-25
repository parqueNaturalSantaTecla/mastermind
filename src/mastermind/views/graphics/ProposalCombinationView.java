package mastermind.views.graphics;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import mastermind.views.Message;

@SuppressWarnings("serial")
class ProposalCombinationView extends JPanel implements ActionListener, KeyListener{
	
	private static final String ACCEPT = "Aceptar";
	
	private JLabel label;
	
	private JTextField textField;
	
	private JButton button;
	
	private String characters;

	ProposalCombinationView(JRootPane rootPane) {
		this.setLayout(new GridBagLayout());
		this.label = new JLabel(Message.PROPOSED_COMBINATION.getMessage());
		this.add(label, new Constraints(0, 0, 1, 1));
		this.textField = new JTextField(10);
		this.add(textField, new Constraints(0, 1, 1, 1));
		this.button = new JButton(ProposalCombinationView.ACCEPT);
		rootPane.setDefaultButton(this.button);
		this.button.addActionListener(this);
		this.button.addKeyListener(this);
		this.add(button, new Constraints(0, 2, 1, 1));	
		this.resetCharacters();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.characters = this.textField.getText();
		this.textField.setText("");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.characters = this.textField.getText();
		this.textField.setText("");
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	String getCharacters() {
		return this.characters;
	}

	void resetCharacters() {
		this.characters = "";
	}

}
