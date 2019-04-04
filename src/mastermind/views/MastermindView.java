package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.utils.Menu;
import mastermind.utils.WithConsoleView;

public class MastermindView extends WithConsoleView {

	private Mastermind mastermind;
	
	private Menu menu;

	public MastermindView(Mastermind mastermind) {
		this.mastermind = mastermind;
		this.menu = new Menu();
	}

	public void write() {
		this.console.writeln(Message.TITLE.getMessage());
		for (int i = 0; i < this.mastermind.getSecretCombination().getColors().size(); i++) {
			this.console.write('*');
		}
		do {
			this.menu.execute();
		}while (this.mastermind.isWinner() || this.mastermind.isLooser());
	}

}
