package challenges;

public class Class3Palindrome {

	public static void main(String[] args) {
		
		String str = "A man, a plan, a canal: Panama";
		//String str= "race a car";
		//String str=" ";
		//String str="Mr. Owl ate my metal worm";
		//String str="Do goose see God?";
		String newStr=str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int setVar=0;
		
		int j =newStr.length()-1;
		for(int i=0; i<newStr.length();i++)
		{
			if(newStr.charAt(i)!=newStr.charAt(j))
			{
				setVar = 1;
			}
			j--;
		}
		
		if(setVar==1)
		{
		System.out.println("Not a Palindrome");
		}
		else
		{
			System.out.println("It is a Palindrome");
		}
	}
}
