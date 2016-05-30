import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input=new Scanner (System.in);
		BigInteger a,b;
		while(input.hasNext())
		{
			a=input.nextBigInteger();
			b=input.nextBigInteger();
			System.out.println(a.multiply(b));
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
