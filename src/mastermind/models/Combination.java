package mastermind.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class Combination {
	
	private static final int WIDTH = 4;

	protected List<Color> colors;
	
	protected Combination (){
		this.colors = new ArrayList<Color>();
	}
	
	public static int getWidth() {
		return Combination.WIDTH;
	}
	
	public void save(FileWriter fileWriter) {
		try {
			for (Color color : this.colors) {
				fileWriter.write(color.ordinal() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			for (int i = 0; i < Combination.getWidth(); i++) {
				int ordinal = Integer.parseInt(bufferedReader.readLine());
				this.colors.add(Color.getInstance(ordinal));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
