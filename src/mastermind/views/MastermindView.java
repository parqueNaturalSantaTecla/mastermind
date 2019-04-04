package mastermind.views;

import mastermind.models.Mastermind;
import mastermind.mvcUtils.Event;
import mastermind.mvcUtils.NewGameEvent;
import mastermind.mvcUtils.Observed;
import mastermind.mvcUtils.Observer;
import mastermind.mvcUtils.EndGameEvent;
import mastermind.utils.Menu;
import mastermind.utils.YesNoDialog;

public class MastermindView extends Observed implements Observer{

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
		this.console.writeln();
		do {
			this.menu.execute();
		} while (!this.mastermind.isWinner() && !this.mastermind.isLooser());
		if (this.mastermind.isWinner()) {
			this.console.writeln(Message.WINNER.getMessage());
		} else if (this.mastermind.isLooser()) {
			this.console.writeln(Message.LOOSER.getMessage());
		}
	}

	@Override
	public void update(Observed observed, Event event) {
		if (event instanceof EndGameEvent) {
			this.resume();
		}
	}

	private void resume() {
		if (new YesNoDialog().read(Message.RESUME.getMessage())) {
			this.notify(new NewGameEvent());
		}
	}

}
