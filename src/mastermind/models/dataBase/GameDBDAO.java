package mastermind.models.dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import mastermind.models.Game;
import mastermind.models.DAO.GameDAO;

public class GameDBDAO extends GameDAO implements DBDAO {

	private SecretCombinationDBDAO secretCombinationDBDAO;

	protected GameDBDAO(Game game) {
		super(game);
		this.secretCombinationDBDAO = new SecretCombinationDBDAO(this.game.getSecretCombination());
	}

	@Override
	public void save(String name, Connection connection, Boolean exists) {
		for (int i = 0; i < this.game.getTurn(); i++) {
			if (exists) {
				this.update(name, connection, i);
			} else {
				this.insert(name, connection, i);
			}			
		}
	}

	private void insert(String name, Connection connection, int turn) {
		String proposedCombinationCodes = "";
		for (int i = 0; i < this.game.getProposedCombinationCodes(turn).length; i++) {
			proposedCombinationCodes += this.game.getProposedCombinationCodes(turn)[i];
		}
		String sql = "INSERT INTO Rounds VALUES ('" + name + "'," + (turn+1) + ",'" +
				proposedCombinationCodes + "'," +
				this.game.getResult(turn).getBlacks() + "," +
				this.game.getResult(turn).getWhites() + ");";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update(String name, Connection connection, int turn) {
		String proposedCombinationCodes = "";
		for (int i = 0; i < this.game.getProposedCombinationCodes(turn).length; i++) {
			proposedCombinationCodes += this.game.getProposedCombinationCodes(turn)[i];
		}
		String sql = "UPDATE Rounds SET " + 
				"turn = " + (turn+1) + " " +
				"proposedCombination = '" + proposedCombinationCodes + "', " +
				"blacks = " + this.game.getResult(turn).getBlacks() + "', " +
				"whites = " + this.game.getResult(turn).getWhites() + " " +
				"WHERE name = '" + name + "';";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String name, Connection connection) {
	}

}
