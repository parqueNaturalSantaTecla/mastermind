package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Observer;
import mastermind.utils.Menu;
import mastermind.utils.WithConsoleView;

public class MastermindView extends WithConsoleView {

	private Mastermind mastermind;

	private Menu menu;

	public MastermindView(Mastermind mastermind, Observer observer) {
		this.mastermind = mastermind;
		this.menu = new Menu(mastermind, observer);
	}

	public void write() {
		this.console.writeln(Message.TITLE.getMessage());
		for (int i = 0; i < this.mastermind.getSecretCombination().getColors().size(); i++) {
			this.console.write('*');
		}
		do {
			this.menu.execute();
		} while (!this.mastermind.isWinner() || !this.mastermind.isLooser());
		if (this.mastermind.isWinner()) {
			
		}else is (this.mastermind.isLooser()){
			
		}
	}

}
