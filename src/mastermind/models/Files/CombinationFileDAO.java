package mastermind.models.Files;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.Combination;
import mastermind.models.DAO.CombinationDAO;
import mastermind.types.Color;

abstract class CombinationFileDAO extends CombinationDAO implements FileDAO{
	
	CombinationFileDAO(Combination combination) {
		super(combination);
	}

	public void save(FileWriter fileWriter) {
		try {
			for (Color color : this.combination.getColors()) {
				fileWriter.write(color.name() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			for (int i = 0; i < Combination.getWidth(); i++) {
				String color = bufferedReader.readLine();
				this.combination.addColor(Color.valueOf(color));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
