package mastermind;

import mastermind.models.Game;
import mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind {
	
	private Game game;

	private GraphicsView graphicsView;

	private GraphicsMastermind() {
		this.game = new Game();
		this.graphicsView = new GraphicsView(this.game);
	}

	private void play() {
		this.graphicsView.interact();
	}
	
	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
