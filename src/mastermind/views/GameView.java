package mastermind.views;

import mastermind.utils.WithConsoleView;

public class GameView extends WithConsoleView {

	private int turn;

	private int width;

	private int[][][] allCodes;

	public GameView() {
	}

	public void writeGame() {
		this.console.writeln();
		this.console.writeln(Message.TURN.getMessage().replaceFirst("#turn", "" + this.turn));
		new SecretCombinationView().writeln(this.width);
		for (int i = 0; i < this.allCodes.length; i++) {
			new ProposedCombinationView().write(this.allCodes[i][0]);
			new ResultView().writeln(this.allCodes[i][1]);
		}
	}

	public void writeLooser() {
		this.console.writeln(Message.LOOSER.getMessage());
	}

	public void writeWinner() {
		this.console.writeln(Message.WINNER.getMessage());
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setAllCodes(int[][][] allCodes) {
		this.allCodes = allCodes;
	}

}
