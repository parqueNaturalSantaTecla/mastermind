package mastermind;

import mastermind.utils.WithConsoleModel;

class Result extends WithConsoleModel{

	private int blacks = 0;

	private int whites = 0;

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	void writeln() {
		Message.RESULT.writeln(this.blacks, this.whites);
	}
	
}
