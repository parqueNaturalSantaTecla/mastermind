package mastermind.models;

public enum Color {
	RED, 
	BLUE, 
	YELLOW, 
	GREEN, 
	ORANGE, 
	PURPLE;

	public static Color getInstance(int code) {
		assert 0 <= code && code < Color.length();
		return Color.values()[code];
	}

	public static int length() {
		return Color.values().length;
	}
	
	public static void main(String[] args) {
		assert(Color.getInstance(2) == Color.YELLOW);
		assert(Color.length()==6);
	}

}
