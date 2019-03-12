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
	EXISTS, 
	HAS_NAME, 
	SAVE,
	NEXT,
	CLOSE, START_NAME, TITLES, GET_TITLE, SET_TITLE, SAVE_NAMED;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
