package mastermind.models.dataBase;

import mastermind.models.Game;
import mastermind.models.DAO.GameDAO;

public class GameDBDAO extends GameDAO implements DBDAO {

	private SecretCombinationDBDAO secretCombinationDBDAO;

	protected GameDBDAO(Game game) {
		super(game);
		this.secretCombinationDBDAO = new SecretCombinationDBDAO(this.game.getSecretCombination());
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
