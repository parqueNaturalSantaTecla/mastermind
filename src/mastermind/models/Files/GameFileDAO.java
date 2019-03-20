package mastermind.models.Files;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.models.DAO.GameDAO;

class GameFileDAO extends GameDAO implements FileDAO {

	private SecretCombinationFileDAO secretCombinationFileDAO;

	GameFileDAO(Game game) {
		super(game);
		this.secretCombinationFileDAO = new SecretCombinationFileDAO(this.game.getSecretCombination());
	}

	public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.game.getTurn() + "\n");
			this.secretCombinationFileDAO.save(fileWriter);
			for (int i = 0; i < this.game.getTurn(); i++) {
				new ProposedCombinationFileDAO(this.game.getProposedCombination(i)).save(fileWriter);
				new ResultFileDAO(this.game.getResult(i)).save(fileWriter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			this.game.setTurn(Integer.parseInt(bufferedReader.readLine()));
			this.secretCombinationFileDAO.load(bufferedReader);
			for (int i = 0; i < this.game.getTurn(); i++) {
				ProposedCombinationFileDAO proposedCombinationFileDAO = new ProposedCombinationFileDAO(
						new ProposedCombination());
				proposedCombinationFileDAO.load(bufferedReader);
				this.game.addProposedCombination(proposedCombinationFileDAO.getProposedCombination());
				ResultFileDAO resultFileDAO = new ResultFileDAO(new Result());
				resultFileDAO.load(bufferedReader);
				this.game.addResult(resultFileDAO.getResult());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
