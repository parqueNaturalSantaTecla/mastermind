package santaTecla.utils;

import java.util.ArrayList;
import java.util.Set;

import mastermind.views.MessageView;

public class Menu extends WithConsoleView {

	private ArrayList<Command> commandSet;

	public Menu(Set<Command> commandSet) {
		this.commandSet = new ArrayList<Command>(commandSet);
	}

	public Command execute() {
		ArrayList<Command> commands = new ArrayList<Command>();
		for (int i = 0; i < this.commandSet.size(); i++) {
			if (this.commandSet.get(i).isActive()) {
				commands.add(this.commandSet.get(i));
			}
		}
		boolean error;
		int option;
		do {
			error = false;
			this.console.writeln();
			this.console.writeln(MessageView.OPTION.getMessage());
			for (int i = 0; i < commands.size(); i++) {
				this.console.writeln((i + 1) + ") " + commands.get(i).getTitle());
			}
			option = this.console.readInt("") - 1;
			if (!new ClosedInterval(0, commands.size()-1).includes(option)) {
				error = true;
			} 				
		} while (error);
		return commands.get(option);
	}

}
