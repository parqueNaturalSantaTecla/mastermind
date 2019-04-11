package mastermind.views;

import java.util.ArrayList;

import mastermind.models.Mastermind;
import mastermind.utils.Command;
import mastermind.utils.Observer;

public class Menu extends mastermind.utils.Menu {

	public Menu(Mastermind mastermind, Observer observer) {
		this.commands = new ArrayList<Command>();
		this.commands.add(new ProposeCommand(mastermind, observer));
		this.commands.add(new UndoCommand(mastermind, observer));
		this.commands.add(new RedoCommand(mastermind, observer));
	}

}
