package week3.day2.homeassignment;

public class MySqlConnection implements DatabaseConnection {

	@Override
	public void connect() {
		
	}

	@Override
	public void disconnect() {
		
	}

	@Override
	public void executeUpdate() {
		
	}
	
	public void executeQuery() {
		System.out.println("This is executeQuery from abstract class MySQLConnections");
	}
	

}
