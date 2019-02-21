package mastermind;

import mastermind.controllers.Controller;
import mastermind.controllers.Logic;
import mastermind.views.console.ConsoleView;
import mastermind.views.graphics.GraphicsView;

public class Mastermind {
	
	private Logic logic;
	private ConsoleView consoleView;
	private GraphicsView graphicsView;
	
	private Mastermind() {
		this.logic = new Logic();
		this.graphicsView = new GraphicsView();
//		this.consoleView = new ConsoleView();
	}
	
	private void play() {
		Controller controller;
		do {
			controller = this.logic.getController();
			if (controller != null){
				this.graphicsView.interact(controller);
//				this.consoleView.interact(controller);
			}
		} while (controller != null); 
	}
	
	public static void main(String[] args) {
		new Mastermind().play();
	}
	
}

