package mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;

class GameDAO implements DAO {

	private Game game;

	private SecretCombinationDAO secretCombinationDAO;

	GameDAO(Game game) {
		this.game = game;
		this.secretCombinationDAO = new SecretCombinationDAO(this.game.getSecretCombination());
	}

	public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.game.getAttempts() + "\n");
			this.secretCombinationDAO.save(fileWriter);
			for (int i = 0; i < this.game.getAttempts(); i++) {
				new ProposedCombinationDAO(this.game.getProposedCombination(i)).save(fileWriter);
				new ResultDAO(this.game.getResult(i)).save(fileWriter);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			this.game.setAttempts(Integer.parseInt(bufferedReader.readLine()));
			this.secretCombinationDAO.load(bufferedReader);
			for (int i = 0; i < this.game.getAttempts(); i++) {
				ProposedCombinationDAO proposedCombinationDAO = new ProposedCombinationDAO(new ProposedCombination());
				proposedCombinationDAO.load(bufferedReader);
				this.game.addProposedCombination(proposedCombinationDAO.getProposedCombination());
				ResultDAO resultDAO = new ResultDAO(new Result());
				resultDAO.load(bufferedReader);
				this.game.addResult(resultDAO.getResult());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
