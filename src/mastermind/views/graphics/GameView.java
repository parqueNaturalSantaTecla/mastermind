package mastermind.views.graphics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mastermind.controllers.ProposalController;
import mastermind.controllers.StartController;
import mastermind.views.graphics.ErrorView;
import mastermind.views.graphics.ProposedCombinationView;
import mastermind.views.graphics.ResultView;
import mastermind.views.graphics.SecretCombinationView;

@SuppressWarnings("serial")
public class GameView extends JFrame implements ActionListener{
	
	private static String TITLE = "MASTERMIND";
	private JPanel[] arrayPane;
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private String characters;
	
	public GameView () {
		super(TITLE);
		characters = "";
		this.getContentPane().setLayout (new GridBagLayout());
		arrayPane = new JPanel[3];
		for(int i=0;i<3;i++) {
			arrayPane[i] = new JPanel();
		}
		this.arrayPane[1].setLayout(new GridBagLayout());
		this.arrayPane[2].setLayout(new GridBagLayout());
		label = new JLabel("Propón una combinación");
		textField = new JTextField(10);
		button = new JButton("Aceptar");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		this.getContentPane().add (arrayPane[0], constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 10;
		this.getContentPane().add(arrayPane[1], constraints);
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 10;
		this.getContentPane().add(arrayPane[2], constraints);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.arrayPane[2].add(label, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.arrayPane[2].add(textField, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		this.arrayPane[2].add(button, constraints);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.button.addActionListener(this);
	}

	public void interact(StartController startController) {
		startController.start();
		this.arrayPane[0].add(new SecretCombinationView(startController.getWidth()));
		this.arrayPane[1].add(new ProposedCombinationView());
		this.setVisible(true);
	}
	
	public void interact(ProposalController proposalController) {
		int error;
		int[] codes;
		do {
			codes = new ProposedCombinationView().read(this.characters);
			error = proposalController.proposeCombination(codes);
			if (error != ProposalController.NO_ERROR) {
				new ErrorView(error);
			}
		} while (error != ProposalController.NO_ERROR || this.characters=="");
		this.characters = "";
		int[][][] allCodes = proposalController.getAllCodes();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = proposalController.getTurn();
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		arrayPane[1].add(new JLabel(""+proposalController.getTurn()),constraints);
		constraints.gridx = 1;
		arrayPane[1].add(new ProposedCombinationView(codes),constraints);
		constraints.gridx = 2;
		arrayPane[1].add(new ResultView(allCodes[allCodes.length-1][1]),constraints);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.characters = this.textField.getText();
		this.textField.setText("");
	}

}
