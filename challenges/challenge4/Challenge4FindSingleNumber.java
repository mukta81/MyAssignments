package challenges;

import java.util.Arrays;

public class Challenge4FindSingleNumber {

	public static void main(String[] args) {
		Challenge4FindSingleNumber obj = new Challenge4FindSingleNumber();
		
		int[] arr = {4,1,2,1,2};
		Arrays.sort(arr);
		
		int ans=obj.findUniqueNumber(arr);
		if(ans==0)
		{
			System.out.println("No Value is Unique");
		}
		else
		{
		System.out.println("Unique Value is "+ ans);
		}
	}
	//{1,1,2,2,4}
	public int findUniqueNumber(int[] arr)
	{
		if(arr.length==1)
		{
			return arr[0];
		}
		
		for(int i=0; i<arr.length-1; i+=2)
		{
		//	System.out.println(i+","+arr[i]);
	            if(arr[i]!=arr[i+1])
	            {
	            	return arr[i]; 
	            }
		}
		
		if(arr.length%2==1)
			{
				return arr[arr.length - 1];
			}
		else 
			{
				return 0;
			}
	}
}
