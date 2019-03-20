package mastermind.models.Files;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.Result;
import mastermind.models.DAO.ResultDAO;

public class ResultFileDAO extends ResultDAO implements FileDAO {

	ResultFileDAO(Result result) {
		super(result);
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

}
