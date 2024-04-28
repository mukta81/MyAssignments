package week1.day2;

public class Browser {
	
	public static void main(String[] args) {
		Browser obj = new Browser();
		System.out.println(obj.launchBrowser("Firefox"));
		obj.loadUrl();
	}
	
	
	public String launchBrowser(String browserName) {
		System.out.println("Browser launched successfully");
		return browserName;
	}

	
	public void loadUrl() {
		System.out.println("Application url loaded successfully");
	}
}
