package mastermind;
import mastermind.controllers.Controller;
import mastermind.controllers.Logic;
import mastermind.views.console.ConsoleView;
import mastermind.views.graphics.GraphicsView;

public class Mastermind {
	
	private Logic logic;
	
	private GraphicsView graphicsView;
	
	public Mastermind() {
		this.logic = new Logic();
		this.graphicsView = new GraphicsView();
	}
	
	public void play() {
		Controller controller;
		do {
			controller = this.logic.getController();
			if (controller != null){
				this.graphicsView.interact(controller);
			}
		} while (controller != null); 
	}
	
	public static void main(String[] args) {
		new Mastermind().play();
	}
	
}

