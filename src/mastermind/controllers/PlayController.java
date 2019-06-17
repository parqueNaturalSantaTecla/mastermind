package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;
import mastermind.models.Session;
import mastermind.views.ProposeCommand;
import mastermind.views.RedoCommand;
import mastermind.views.UndoCommand;
import santaTecla.utils.Command;
import santaTecla.utils.Menu;

public class PlayController extends Controller {

	private Map<Command, Controller> controllers;

	private ProposeCommand proposeCommand;

	private ProposalController proposalController;

	private UndoCommand undoCommand;

	private UndoController undoController;

	private RedoCommand redoCommand;

	private RedoController redoController;

	private Menu menu;

	public PlayController(Session session) {
		super(session);
		this.controllers = new HashMap<Command, Controller>();
		this.proposeCommand = new ProposeCommand(this.session);
		this.proposalController = new ProposalController(this.session);
		this.controllers.put(this.proposeCommand, this.proposalController);
		this.undoCommand = new UndoCommand(this.session);
		this.undoController = new UndoController(this.session);
		this.controllers.put(this.undoCommand, this.undoController);
		this.redoCommand = new RedoCommand(this.session);
		this.redoController = new RedoController(this.session);
		this.controllers.put(this.redoCommand, this.redoController);
		this.menu = new Menu(this.controllers.keySet());
	}

	@Override
	public void control() {
		this.proposeCommand.updateIsActive();
		this.undoCommand.updateIsActive();
		this.redoCommand.updateIsActive();
		this.controllers.get(this.menu.execute()).control();
	}

}
