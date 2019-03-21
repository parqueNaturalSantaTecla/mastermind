package mastermind.models.dataBase;

import java.sql.Connection;

public interface DBDAO {

	void save (String name, Connection connection, Boolean exists);
	
	void load (String name, Connection connection);

}
