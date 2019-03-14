package mastermind;

import mastermind.models.Game;
import mastermind.views.View;
import mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind{

	@Override
	protected View createView(Game game) {
		return new GraphicsView(game);
	}
	
	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
