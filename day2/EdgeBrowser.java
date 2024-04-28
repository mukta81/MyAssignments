package week1.day2;

public class EdgeBrowser {

	public static void main(String[] args) {
		Browser objNew = new Browser();
		System.out.println(objNew.launchBrowser("Firefox"));
		objNew.loadUrl();
	}

}
