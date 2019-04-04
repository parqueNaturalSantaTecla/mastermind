package mastermind.utils;

import java.util.ArrayList;
import mastermind.mvcUtils.Observed;

public class Menu extends Observed {

	private static final String OPTION = "----- Elige una opción -----";

	private ArrayList<Command> commands;

	public Menu() {
		this.commands = new ArrayList<Command>();
	}

	public void execute() {
		ArrayList<Command> commands = new ArrayList<Command>();
		for (int i = 0; i < this.commands.size(); i++) {
			if (this.commands.get(i).isActive()) {
				commands.add(this.commands.get(i));
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
		this.no
		commands.get(option);
	}

}
