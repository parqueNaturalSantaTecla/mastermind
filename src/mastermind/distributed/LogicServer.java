package mastermind.distributed;

import mastermind.controllers.Logic;
import mastermind.distributed.dispatchers.AllCodesDispatcher;
import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.distributed.dispatchers.LooserDispatcher;
import mastermind.distributed.dispatchers.ProposeCombinationDispatcher;
import mastermind.distributed.dispatchers.RedoDispatcher;
import mastermind.distributed.dispatchers.RedoableDispatcher;
import mastermind.distributed.dispatchers.ResumeDispatcher;
import mastermind.distributed.dispatchers.StartDispatcher;
import mastermind.distributed.dispatchers.StateDispatcher;
import mastermind.distributed.dispatchers.TurnDispatcher;
import mastermind.distributed.dispatchers.UndoDispatcher;
import mastermind.distributed.dispatchers.UndoableDispatcher;
import mastermind.distributed.dispatchers.WidthDispatcher;
import mastermind.distributed.dispatchers.WinnerDispatcher;

public class LogicServer extends Logic {

	public LogicServer(Boolean isStandalone) {
		super(isStandalone);
	}

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startController));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.LOOSER, new LooserDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.TURN, new TurnDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ALLCODES, new AllCodesDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.PROPOSECOMBINATION,
				new ProposeCombinationDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.RESUME, new ResumeDispatcher(this.resumeController));
	}

}
