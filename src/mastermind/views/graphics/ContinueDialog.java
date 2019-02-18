package mastermind.views.graphics;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mastermind.controllers.ResumeController;

public class ContinueDialog extends JDialog{
	
	JPanel messagePane;
	JLabel label;
	JPanel buttonPane;
	JButton yesButton;
	JButton noButton;
	String message = "";

	public ContinueDialog() {
		super();
		message = "¿Desea continuar?";
		messagePane = new JPanel();
		label = new JLabel(message);
		messagePane.add(label);
		buttonPane = new JPanel();
		yesButton = new JButton("Sí");
		noButton = new JButton("No");
		buttonPane.add(yesButton);
		buttonPane.add(noButton);
		this.getContentPane().add(messagePane);
		this.getContentPane().add(buttonPane, BorderLayout.PAGE_END);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("MASTERMIND");
        
	}

	public void interact(ResumeController continueController) {
		// TODO Auto-generated method stub
		
	}

}
