package week3.day2.homeassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementList {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 10, 6, 8};
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++)
		{
			list.add(arr[i]);
		}

		Collections.sort(list);

		System.out.print("Missing numbers are: ");
		for(int j=0; j<list.size()-1; j++)
		{
			int k=list.get(j);
			int l=list.get(j+1);
			if(k+1!=l)
			{
				System.out.print(k+1+",");
			}

		}
	}

}
