package mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.Combination;
import mastermind.types.Color;

abstract class CombinationDAO implements DAO{
	
	protected Combination combination;
	
	CombinationDAO(Combination combination) {
		this.combination = combination;
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
				System.out.println(color);
				this.combination.addColor(Color.valueOf(color));
			}
			System.out.println("-");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
