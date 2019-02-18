package mastermind;
import mastermind.controllers.Controller;
import mastermind.controllers.Logic;
import mastermind.views.ConsoleView;

public class Mastermind {
	
	private Logic logic;
	
	private ConsoleView consoleView;
	
	public Mastermind() {
		this.logic = new Logic();
		this.consoleView = new ConsoleView();
	}
	
	public void play() {
		Controller controller;
		do {
			controller = this.logic.getController();
			if (controller != null){
				this.consoleView.interact(controller);
			}
		} while (controller != null); 
	}
	
	public static void main(String[] args) {
		new Mastermind().play();
	}
	
}

