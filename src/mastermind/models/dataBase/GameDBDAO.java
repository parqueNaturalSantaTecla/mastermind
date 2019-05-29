package mastermind.models.dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mastermind.models.Combination;
import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.models.DAO.GameDAO;
import mastermind.types.Color;

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
		for (int i = 0; i < this.game.getAttempts(); i++) {
			this.insert(name, connection, i);
		}
	}

	private void insert(String name, Connection connection, int attempts) {
		String proposedCombination = "";
		for (int i = 0; i < Combination.getWidth(); i++) {
			proposedCombination += this.game.getProposedCombination(attempts).getColors().get(i).name();
			if (i!=Combination.getWidth()) {
				proposedCombination += " ";
			}
		}
		String sql = "INSERT INTO Rounds VALUES ('" + name + "'," + (attempts + 1) + ",'" + proposedCombination + "',"
				+ this.game.getResult(attempts).getBlacks() + "," + this.game.getResult(attempts).getWhites() + ");";
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
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String proposedCombination = result.getString("proposedCombination");
				String[] colorsVector = proposedCombination.split(" ");
				List<Color> colors = new ArrayList<Color>();
				for (int i = 0; i < Combination.getWidth(); i++) {
					colors.add(Color.valueOf(colorsVector[i]));
				}
				this.game.addProposedCombination(new ProposedCombination(colors));
				int blacks = Integer.parseInt(result.getString("blacks"));
				int whites = Integer.parseInt(result.getString("whites"));
				this.game.addResult(new Result(blacks, whites));
				if (result.isLast()) {
					this.game.setAttempts(Integer.parseInt(result.getString("attempts")));
				}
			}
			sql = "SELECT * FROM Games WHERE name = '" + name + "';";
			result = statement.executeQuery(sql);
			while (result.next()) {
				String secretCombination = result.getString("secretCombination");
				String[] colorsVector = secretCombination.split(" ");
				List<Color> colors = new ArrayList<Color>();
				for (int i = 0; i < Combination.getWidth(); i++) {
					colors.add(Color.valueOf(colorsVector[i]));
				}
				this.game.setSecretCombination(colors);
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
