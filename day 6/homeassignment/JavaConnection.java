package week3.day2.homeassignment;

public class JavaConnection extends MySqlConnection implements DatabaseConnection {

	public static void main(String[] args) {
		JavaConnection obj = new JavaConnection();
		obj.connect();
		obj.executeUpdate();
		obj.disconnect();
		obj.executeQuery();
		
	}

	@Override
	public void connect() {
		System.out.println("Connecting to database -> from concrete class JavaConnection");
		
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnecting from database -> from concrete class JavaConnection");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Executing Update in database -> from concrete class JavaConnection");
		
	}

}
