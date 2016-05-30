import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BigInteger x;
		long n;
		Scanner input=new Scanner(System.in);
		while(input.hasNext())
		{
			n=input.nextLong();
			n=n*(n+1)/2;
			x=BigInteger.valueOf(n).pow(2);
			System.out.println(x);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
