package mastermind.views;

import java.util.ArrayList;

import mastermind.models.Mastermind;
import santaTecla.utils.Command;
import santaTecla.utils.Observer;

public class Menu extends santaTecla.utils.Menu {

	public Menu(Mastermind mastermind, Observer observer) {
		this.commands = new ArrayList<Command>();
		this.commands.add(new ProposeCommand(mastermind, observer));
		this.commands.add(new UndoCommand(mastermind, observer));
		this.commands.add(new RedoCommand(mastermind, observer));
	}

}
