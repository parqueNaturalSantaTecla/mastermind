package mastermind;

import mastermind.controllers.Logic;
import mastermind.controllers.implementation.LogicImplementation;
import mastermind.models.DAO.SessionImplementationDAO;

public class MastermindStandalone extends Mastermind{

	@Override
	protected Logic createLogic() {
		return new LogicImplementation(new SessionImplementationDAO());
	}
	
	public static void main(String[] args) {
		new MastermindStandalone().play();
	}

}
