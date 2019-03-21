package mastermind.models.dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mastermind.models.Combination;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.models.DAO.GameDAO;

public class GameDBDAO extends GameDAO implements DBDAO {

	protected GameDBDAO(Game game) {
		super(game);
	}

	@Override
	public void save(String name, Connection connection, Boolean exists) {
		if (exists) {
			String sql = "DELETE FROM Rounds WHERE name = '" + name + "';";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < this.game.getTurn(); i++) {
			this.insert(name, connection, i);
		}
	}

	private void insert(String name, Connection connection, int turn) {
		String proposedCombinationCodes = "";
		for (int i = 0; i < this.game.getProposedCombinationCodes(turn).length; i++) {
			proposedCombinationCodes += this.game.getProposedCombinationCodes(turn)[i];
		}
		String sql = "INSERT INTO Rounds VALUES ('" + name + "'," + (turn + 1) + ",'" + proposedCombinationCodes + "',"
				+ this.game.getResult(turn).getBlacks() + "," + this.game.getResult(turn).getWhites() + ");";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String name, Connection connection) {
		String sql = "SELECT * FROM Rounds WHERE name = '" + name + "';";
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String proposedCombination = result.getString("proposedCombination");
				int[] codes = new int[Combination.getWidth()];
				for (int i = 0; i < proposedCombination.length(); i++) {
					codes[i] = proposedCombination.charAt(i) - '0';
				}
				this.game.addProposedCombination(ProposedCombination.getInstance(codes));
				int blacks = Integer.parseInt(result.getString("blacks"));
				int whites = Integer.parseInt(result.getString("whites"));
				this.game.addResult(new Result(blacks, whites));
				int turn = Integer.parseInt(result.getString("turn"));
				if (result.isLast()) {
					this.game.setTurn(turn);
				}
			}
			sql = "SELECT * FROM Games WHERE name = '" + name + "';";
			result = statement.executeQuery(sql);
			while (result.next()) {
				String secretCombination = result.getString("secretCombination");
				int[] codes = new int[Combination.getWidth()];
				for (int i = 0; i < secretCombination.length(); i++) {
					codes[i] = secretCombination.charAt(i) - '0';
				}
				this.game.setSecretCombination(codes);
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
