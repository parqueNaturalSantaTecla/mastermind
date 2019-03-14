package mastermind;

import mastermind.models.Game;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	@Override
	protected View createView(Game game) {
		return new ConsoleView(game);
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
	
}
