package mastermind.distributed;

import mastermind.controllers.implementation.LogicImplementation;
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

public class LogicImplementationServer extends LogicImplementation {

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.LOOSER, new LooserDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.TURN, new TurnDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ALLCODES, new AllCodesDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PROPOSECOMBINATION,
				new ProposeCombinationDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.RESUME, new ResumeDispatcher(this.resumeControllerImplementation));
	}

}
