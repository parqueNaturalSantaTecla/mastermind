package mastermind;

import mastermind.models.Game;
import mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind {
	
	private Game game;

	private GraphicsView graphicsView;

	protected GraphicsMastermind() {
		this.game = new Game();
		this.graphicsView = new GraphicsView(this.game);
	}

	protected void play() {
		this.graphicsView.interact();
	}
	
	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
