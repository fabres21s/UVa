import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		long A,B,C;
		int k=input.nextInt(),i;
		for(i=0;i<k;i++)
		{
			A=input.nextLong();
			B=input.nextLong();
			C=input.nextLong();
		 System.out.printf("Case %d: ", i + 1);
	     if (A + B <= C || B + C <= A || A + C <= B)
	    	 System.out.printf("Invalid\n");
	     else if (A == B) {
	         if (B == C)
	        	 System.out.printf("Equilateral\n");
	         else
	        	 System.out.printf("Isosceles\n");
	     }
	     else if (A == C || B == C)
	    	 System.out.printf("Isosceles\n");
	     else
	    	 System.out.printf("Scalene\n");
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
