package mastermind.utils;

import java.util.ArrayList;

public abstract class Menu extends WithConsoleView {
	
	private static final String OPTION = "----- Elige una opción -----";
	
	ArrayList<Command> commandList;
	
	public Menu() {
		this.commandList = new ArrayList<Command>();
	}
	
	public void execute() {
		ArrayList<Command> commands = new ArrayList<Command>();
		for (int i=0; i<this.commandList.size(); i++) {
			if (this.commandList.get(i).isActive()) {
				commands.add(this.commandList.get(i));		
			}
		}
		boolean error = false;
		do {
			this.console.writeln();
			this.console.writeln(Menu.OPTION);
			for (int i=0;i<commands.size();i++) {
				this.console.writeln((i+1) +") " + commands.get(i).getTitle());
			}
			int option = this.console.readInt("") - 1;
			if (option>=0 && option<commands.size()) {
				commands.get(option).execute();
			}else error=true;
		}while (error);		
	}
	
	protected void addCommand(Command command) {
		this.commandList.add(command);
	}

}
