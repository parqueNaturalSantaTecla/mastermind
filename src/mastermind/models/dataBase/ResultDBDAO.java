package mastermind.models.dataBase;

import java.sql.Connection;

import mastermind.models.Result;
import mastermind.models.DAO.ResultDAO;

public class ResultDBDAO extends ResultDAO implements DBDAO{
	
	ResultDBDAO(Result result) {
		super(result);
	}

	@Override
	public void save(String name, Connection connection, Boolean exists) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(String name, Connection connection) {
		// TODO Auto-generated method stub
		
	}

}
