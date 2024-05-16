package week3.day2.homeassignment;

import java.util.ArrayList;
import java.util.List;

public class ListFindIntersectionArray {

	public static void main(String[] args) {
		
		int[] arr1 =  {3, 2, 11, 4, 6, 7};
		int[] arr2 = {1, 2, 8, 4, 9, 7};
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for(int i=0; i<arr1.length; i++)
		{
			list1.add(arr1[i]);
		}
		
		for(int j=0; j<arr2.length; j++)
		{
			list2.add(arr2[j]);
		}
		
		
		for(int k=0; k<list1.size(); k++)
		{
			if(list2.contains(list1.get(k)))
			{
				System.out.println(list1.get(k));
			}
		}

	//	System.out.println(list1);
	//	System.out.println(list2);
	}

}
