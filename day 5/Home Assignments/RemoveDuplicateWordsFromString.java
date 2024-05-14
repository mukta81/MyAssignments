package week3.day1.homeassignment;

public class RemoveDuplicateWordsFromString {
	
	public static void main(String[] args) {
		String text = "We learn Java basics as part of java sessions in java week1";
		int count = 0;
		String newtext="";
		
		String[] arrText = text.split(" ");
		
		for(int i=0;i<=arrText.length-1;i++)
		{
		//	System.out.println("Comapre "+arrText[i].toLowerCase());
			for(int j=i+1; j<=arrText.length-1;j++)
			{
			//	System.out.println("with "+arrText[j].toLowerCase());
				if(arrText[i].toLowerCase().equals(arrText[j].toLowerCase()))
					{
				//	System.out.println("yes");
					arrText[j]="";
					count=1;
					}
					
				    
					
			}
			newtext+=arrText[i] + " ";
		}
		
		
		
	
		
			
		System.out.println("Modified String: " + newtext);
			
	}

}
