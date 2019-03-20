package mastermind.models.Files;

import java.io.BufferedReader;
import java.io.FileWriter;

public interface FileDAO {

	void save (FileWriter fileWriter);
	
	void load (BufferedReader bufferedReader);
	
}
