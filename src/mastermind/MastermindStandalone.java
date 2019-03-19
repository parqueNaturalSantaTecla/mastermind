package mastermind;

import mastermind.controllers.Logic;
import mastermind.controllers.implementation.LogicImplementation;
import mastermind.models.DAO.SessionImplementationDAO;

public abstract class MastermindStandalone extends Mastermind{

	@Override
	protected Logic createLogic() {
		return new LogicImplementation(this.createDAO());
	}
	
	protected abstract SessionImplementationDAO createDAO();

}
