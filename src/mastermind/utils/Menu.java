package mastermind.utils;

import java.util.ArrayList;
import mastermind.models.Mastermind;
import mastermind.mvcUtils.Observer;
import mastermind.views.ProposeCommand;
import mastermind.views.RedoCommand;
import mastermind.views.UndoCommand;

public class Menu extends WithConsoleView{

	private static final String OPTION = "----- Elige una opción -----";

	private ArrayList<Command> commands;

	public Menu(Mastermind mastermind, Observer observer) {
		this.commands = new ArrayList<Command>();
		this.commands.add(new ProposeCommand(mastermind, observer));
		this.commands.add(new UndoCommand(mastermind, observer));
		this.commands.add(new RedoCommand(mastermind, observer));
	}

	public void execute() {
		for (Command command: this.commands) {
			command.updateIsActive();
		}
		ArrayList<Command> commands = new ArrayList<Command>();
		for (Command command: this.commands) {
			if (command.isActive()) {
				commands.add(command);
			}
		}
		boolean error;
		int option;
		do {
			error = false;
			this.console.writeln();
			this.console.writeln(Menu.OPTION);
			for (int i = 0; i < commands.size(); i++) {
				this.console.writeln((i + 1) + ") " + commands.get(i).getTitle());
			}
			option = this.console.readInt("") - 1;
			if (!new ClosedInterval(0, commands.size()-1).includes(option)) {
				error = true;
			} 				
		} while (error);
		commands.get(option).execute();
	}

}
