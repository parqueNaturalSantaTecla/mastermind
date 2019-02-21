package mastermind.views.graphics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
public class GameView extends JFrame implements ActionListener, KeyListener {

	private static final String TITLE = "MASTERMIND";
	private static final String MESSAGES = "#turn intento(s): ";
	private JPanel[] arrayPane;
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private String characters;

	public GameView() {
		super(TITLE);
		this.getContentPane().setLayout(new GridBagLayout());
		this.arrayPane = new JPanel[3];
		for (int i = 0; i < 3; i++) {
			this.arrayPane[i] = new JPanel();
			this.arrayPane[i].setLayout(new GridBagLayout());
		}
		this.label = new JLabel("Propón una combinación");
		this.textField = new JTextField(10);
		this.button = new JButton("Aceptar");
		this.characters = "";
		this.button.addActionListener(this);
		this.button.addKeyListener(this);
		this.getRootPane().setDefaultButton(this.button);
		this.getContentPane().add(arrayPane[0], new Constraints(0, 0, 3, 1).getConstraints());
		this.getContentPane().add(arrayPane[1], new Constraints(0, 1, 3, 10).getConstraints());
		this.getContentPane().add(arrayPane[2], new Constraints(0, 11, 3, 1).getConstraints());
		this.arrayPane[2].add(label, new Constraints(0, 0, 1, 1).getConstraints());
		this.arrayPane[2].add(textField, new Constraints(0, 1, 1, 1).getConstraints());
		this.arrayPane[2].add(button, new Constraints(0, 2, 1, 1).getConstraints());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void interact(StartController startController) {
		this.clear();
		startController.start();
		this.arrayPane[0].add(new SecretCombinationView(startController.getWidth()));
		this.arrayPane[1].add(new ProposedCombinationView());
		this.setVisible(true);
	}

	private void clear() {
		this.arrayPane[0].removeAll();
		this.arrayPane[1].removeAll();
	}

	public void interact(ProposalController proposalController) {
		int error;
		int turn = proposalController.getTurn();
		do {
			int[] codes = new ProposedCombinationView().read(this.characters);
			error = proposalController.proposeCombination(codes);
			if (error != ProposalController.NO_ERROR && this.characters != "") {
				new ErrorView(error);
				error = ProposalController.NO_ERROR;
			}
		} while (error != ProposalController.NO_ERROR || this.characters == "");
		this.characters = "";
		int[][][] allCodes = proposalController.getAllCodes();
		arrayPane[1].add(new JLabel(MESSAGES.replaceFirst("#turn", "" + (turn+1))),
				new Constraints(0, turn, 1, 1).getConstraints());
		arrayPane[1].add(new ProposedCombinationView(allCodes[allCodes.length - 1][0]),
				new Constraints(1, turn, 1, 1).getConstraints());
		arrayPane[1].add(new ResultView(allCodes[allCodes.length - 1][1]),
				new Constraints(2, turn, 1, 1).getConstraints());
		this.setVisible(true);
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

}
