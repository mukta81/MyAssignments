package week1.day2.homeassignment;

import java.util.Arrays;

public class FindMissingElement { //print the first missing element in an array

	public static void main(String[] args) {
		
		
		int[] arr =  {1, 4,3,2,8, 6, 7};
		Arrays.sort(arr);
		
		for(int i =0; i<arr.length; i++)
		{
			if (i+1!=arr[i]) 
			{ 	
				System.out.println(i+1);
				break;
			}
					
		
		}
		
	}

}
