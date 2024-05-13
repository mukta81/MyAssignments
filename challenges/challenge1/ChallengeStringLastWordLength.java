package challenges;

public class ChallengeStringLastWordLength {
	public static void main(String[] args) {
		//String str="Hello World";
		//String str="   fly me   to   the moon  ";
		String str="luffy is still joy boy ";
		//String str="luffy is still joyboy";
		int count = 0;
		int firstAlphabetFound=0;
		for(int i =str.length()-1; i>=0; i--)
		{
			if(str.charAt(i)!=' ')
			{
				count+=1;
				firstAlphabetFound=1;
			}
			else if(str.charAt(i)==' ' && firstAlphabetFound==1)
			{
				break;
			}

		}
		System.out.println("Count of last word in the string '"+str+"' is "+count);
		
		}	
}

