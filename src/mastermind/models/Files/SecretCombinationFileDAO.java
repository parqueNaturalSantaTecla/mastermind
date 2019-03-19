package mastermind.models.Files;

import java.io.BufferedReader;

import mastermind.models.SecretCombination;
import mastermind.models.DAO.SecretCombinationDAO;

public class SecretCombinationFileDAO extends SecretCombinationDAO {

	SecretCombinationFileDAO(SecretCombination secretCombination) {
		super(secretCombination);
	}

	public void load(BufferedReader bufferedReader) {
		this.combination.clearColors();
		super.load(bufferedReader);
	}

}
