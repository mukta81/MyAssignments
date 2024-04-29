package week1.day1.HomeAssignment;
// FibonacciSeries until a particular range.
public class FibonacciSeries {

	public static void main(String[] args) {
		
		int firstNumber=0;
		int secondNumber=1;
		int range=8;
		
		System.out.print(firstNumber+","+secondNumber);
		
		
		for(int i=1; i<range-1;i++)
		{
			int nextNumber=firstNumber+secondNumber;
			System.out.print(","+ nextNumber);
			firstNumber=secondNumber;
			secondNumber=nextNumber;
		}

	}

}
