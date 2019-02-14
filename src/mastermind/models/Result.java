package mastermind.models;

public class Result {

	private int blacks = 0;

	private int whites = 0;

	public Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	public boolean isWinner() {
		return blacks == Combination.getWidth();
	}

	public int[] getCodes() {
		return new int[] { this.blacks, this.whites };
	}
	
	public static void main(String[] args) {
		assert(new Result(4,0).isWinner());
		assert(!new Result(2,1).isWinner());
	}

}
