package week3.day1.homeassignment;

public class ReverseOddWords {
	public static void main(String[] args) {
		String test="I am a software tester";
		String str="";
		String newtext="";
		
		//split
		String[] arrText = test.split(" ");
		
		for(int i=0;i<arrText.length;i++)
		{
			if(i%2==1)
			{
				str="";
				
				for(int j=arrText[i].length()-1; j>=0;j--)
				{
						str+=arrText[i].charAt(j);
				
				}
					arrText[i]=str;
			}
			newtext+=arrText[i] + " ";
		}
		

//		for(int i=0;i<arrText.length;i++)
//		{
//		System.out.println("Modified string: " + arrText[i]);
//		}
		System.out.println("Modified String: " + newtext);
	}


}
