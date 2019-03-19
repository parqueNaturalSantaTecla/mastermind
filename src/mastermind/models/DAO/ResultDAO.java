package mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.Result;

class ResultDAO implements DAO {

	private Result result;

	ResultDAO(Result result) {
		this.result = result;
	}

	public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.result.getBlacks() + "\n");
			fileWriter.write(this.result.getWhites() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			this.result.setBlacks(Integer.parseInt(bufferedReader.readLine()));
			this.result.setWhites(Integer.parseInt(bufferedReader.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Result getResult() {
		return this.result;
	}

}
