package week3.day1.homeassignment;

public class APIClient {

	public static void main(String[] args) {
		APIClient obj = new APIClient();
		obj.sendRequest("EP1");
		obj.sendRequest("EP1", "RB2", true);

	}
	
	public void sendRequest(String endpoint)
	{
		System.out.println("Method sendRequest() -> single argument, variable: "+endpoint);
	}
	
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus)
	{
		System.out.println("Method sendRequest() -> multiple argument, variable: "+endpoint+","+requestBody+requestStatus);
	}

}
