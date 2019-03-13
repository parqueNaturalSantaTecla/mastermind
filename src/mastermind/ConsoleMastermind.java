package mastermind;

import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends Mastermind{

	protected View createView(Logic logic) {
		return new ConsoleView(logic);
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
	
}
