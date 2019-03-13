package mastermind;

import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind{

	protected View createView(Logic logic) {
		return new GraphicsView(logic);
	}
	
	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
