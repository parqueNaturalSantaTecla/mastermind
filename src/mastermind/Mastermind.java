package mastermind;

import mastermind.models.Game;
import mastermind.views.View;

public class Mastermind {

	private Game game;
	private View view;

	protected Mastermind() {
		this.game = new Game();
		this.view = new View(this.game);
	}

	protected void play() {
		this.view.interact();
	}
	
	public static void main(String[] args) {
		new Mastermind().play();
	}	

}
