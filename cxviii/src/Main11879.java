import java.math.BigInteger;
import java.util.Scanner;

/*
 *   Fabio Andrés Sierra Jaraba
 *   Multiple of 17
 *   UVa:  11879
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		BigInteger n, q,x;
		q=BigInteger.ZERO;
		x=BigInteger.valueOf(17);
		while(!(n=input.nextBigInteger()).equals(q))
		{
			if(n.mod(x)==q)
			{
				System.out.println(1);
			}
			else
			{
				System.out.println(0);
			}
		}
		// TODO Auto-generated method stub

	}

}
