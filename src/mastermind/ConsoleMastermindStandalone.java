package mastermind;

import mastermind.controllers.Logic;
import mastermind.controllers.implementation.LogicImplementation;

public class ConsoleMastermindStandalone extends ConsoleMastermind{

	@Override
	protected Logic createLogic() {
		return new LogicImplementation();
	}
	
	public static void main(String[] args) {
		new ConsoleMastermindStandalone().play();
	}

}
