package week3.day1.homeassignment;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {
		String str="";
		String test = "changeme";
		
		//string to array
		char[] arrTest=test.toCharArray();
		
		for(int i=0;i<arrTest.length;i++)
		{
		
			if(i%2==1)
			{
				//read each character and change to Upper Case for odd index. 
				str+= Character.toUpperCase(arrTest[i]);
			}
			else
			{
				str+=arrTest[i];
			}
		}
		
		System.out.println("Modified string: " + str);
	}

}
