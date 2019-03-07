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
	TURN, 
	ALLCODES, 
	PROPOSECOMBINATION, 
	WIDTH,
	RESUME,
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
