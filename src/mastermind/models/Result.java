package mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

class Result {

	private int blacks = 0;

	private int whites = 0;

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	Result() {
	}

	void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.blacks + "\n");
			fileWriter.write(this.whites + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(BufferedReader bufferedReader) {
		try {
			this.blacks = Integer.parseInt(bufferedReader.readLine());
			this.whites = Integer.parseInt(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	int[] getCodes() {
		return new int[] { this.blacks, this.whites };
	}

	int getBlacks() {
		return this.blacks;
	}

	int getWhites() {
		return this.whites;
	}

	Result copy() {
		return new Result(this.blacks, this.whites);
	}

	@Override
	public String toString() {
		return "Result [blacks=" + blacks + ", whites=" + whites + "]";
	}

}
