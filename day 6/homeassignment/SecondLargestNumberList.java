package week3.day2.homeassignment;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class SecondLargestNumberList {

	public static void main(String[] args) {
		int[] arr = {3, 2, 11, 4, 6, 7};
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++)
		{
			list.add(arr[i]);
		}
	//	Collections.sort(list);
		list.sort(null);
		
		System.out.println("Second Item from the last in the list is: "+list.get(list.size()-2));
		

	}

}
