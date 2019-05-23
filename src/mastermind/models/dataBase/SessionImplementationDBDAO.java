package mastermind.models.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mastermind.models.Combination;
import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;
import mastermind.models.DAO.SessionImplementationDAO;

public class SessionImplementationDBDAO extends SessionImplementationDAO {

	private static final String URL = "jdbc:mysql://localhost:3306";

	private static final String USER = "root";

	private static final String PASSWORD = "rootroot";

	private GameDBDAO gameDBDAO;

	protected Connection connection;

	public void associate(SessionImplementation sessionImplementation) {
		super.associate(sessionImplementation);
		this.gameDBDAO = new GameDBDAO(this.sessionImplementation.getGame());
	}

	public SessionImplementationDBDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.connection = DriverManager.getConnection(SessionImplementationDBDAO.URL,
					SessionImplementationDBDAO.USER, SessionImplementationDBDAO.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement statement = this.connection.createStatement();
			String sql = "CREATE DATABASE IF NOT EXISTS Mastermind;\n";
			statement.executeUpdate(sql);
			sql = "USE Mastermind;";
			statement.executeUpdate(sql);
			sql = "CREATE TABLE IF NOT EXISTS `Games`\n" + "	(`name` varchar(20) NOT NULL,\n" + "	`attempts`int(2),\n"
					+ "	`secretCombination`varchar(4),\n" + "	PRIMARY KEY (`name`));";
			statement.executeUpdate(sql);
			sql = "CREATE TABLE IF NOT EXISTS `Rounds`\n" + "	(`name` varchar(20) NOT NULL,\n"
					+ "	`attempts`int(2) NOT NULL,\n" + "	`proposedCombination`varchar(4),\n" + "	`blacks`int(1),\n"
					+ "	`whites`int(1),\n" + "	FOREIGN KEY (`name`) REFERENCES `Games` (`name`),\n"
					+ "	PRIMARY KEY (`name`,`attempts`));";
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String name) {
		this.sessionImplementation.setName(name);
		this.gameDBDAO.load(name, this.connection);
		this.sessionImplementation.resetRegistry();
		this.sessionImplementation.setStateValue(StateValue.IN_GAME);
		if (this.sessionImplementation.isLooser() || this.sessionImplementation.isWinner()) {
			this.sessionImplementation.setStateValue(StateValue.FINAL);
		}
	}

	@Override
	public void save(String name) {
		String secretCombinationInitials = "";
		for (int i = 0; i < Combination.getWidth(); i++) {
			secretCombinationInitials += this.sessionImplementation.getSecretCombination().getColors().get(i).name()
					.substring(0, 1);
		}
		if (this.exists(name)) {
			String sql = "UPDATE Games SET " + "attempts = " + this.sessionImplementation.getAttempts() + ", "
					+ "secretCombination = '" + secretCombinationInitials + "' " + "WHERE name = '" + name + "';";
			Statement statement;
			try {
				statement = this.connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.gameDBDAO.save(name, this.connection, true);
		} else {
			String sql = "INSERT INTO Games VALUES ('" + name + "'," + this.sessionImplementation.getAttempts() + ",'"
					+ secretCombinationInitials + "');";
			try {
				Statement statement = this.connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.gameDBDAO.save(name, this.connection, false);
		}
	}

	@Override
	public String[] getGamesNames() {
		String sql = "SELECT name FROM Games";
		ArrayList<String> gamesNames = new ArrayList<String>();
		try {
			Statement statement = this.connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				gamesNames.add(result.getString("name"));
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] names = new String[gamesNames.size()];
		for (int i = 0; i < gamesNames.size(); i++) {
			names[i] = gamesNames.get(i);
		}
		return names;
	}

	@Override
	public boolean exists(String name) {
		String sql = "SELECT name FROM Games";
		try {
			Statement statement = this.connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (result.getString("name").equals(name)) {
					return true;
				}
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
