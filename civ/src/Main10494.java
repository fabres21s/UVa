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
		String op;
		while(input.hasNext())
		{
			a=input.nextBigInteger();
			op=input.next();
			b=input.nextBigInteger();
			if(op.equals("%"))
			{
				System.out.println(a.mod(b));				
			}
			else
			{
				System.out.println(a.divide(b));
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
