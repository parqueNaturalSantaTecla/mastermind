package mastermind.distributed;

public enum FrameType { 
	START, 
	STATE,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE, 
	WINNER, 
	LOOSER, 
	ATTEMPTS, 
	COLORS, 
	PROPOSECOMBINATION, 
	WIDTH,
	RESUME,
	BLACKS,
	WHITES,
	CLOSE;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
