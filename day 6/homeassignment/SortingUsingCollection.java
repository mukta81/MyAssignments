package week3.day2.homeassignment;

import java.util.ArrayList;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		
		String[] arr = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		List<String> str = new ArrayList<>();
		
		for(int i=0; i<arr.length ;i++)
		{
			str.add(arr[i]);
		}
		
		str.sort(null);
		
		for(int j=str.size()-1;j>=0;j--)
		{
			System.out.print(str.get(j)+" , ");
		}
	}

}
