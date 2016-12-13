import java.math.BigInteger;
import java.util.Scanner;

/**
*	389 - Basically Speaking
*
*
*	Submision:	9643083
*	Date:		2012-01-13 22:53:54
*	Runtime:	2.960
*	Ranking:	3559
*/
public class Main389 {

	/**
	 * - Sistemas de numeración
	 */
	public static void main(String[] args) 
	{
		String s,cs;
		int b,t;
		BigInteger a;
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext())
		{
			s=sc.next();
			b=sc.nextInt();
			t=sc.nextInt();
			a=new BigInteger(s,b);
			cs=a.toString(t).toUpperCase();
			if(cs.length()>7)
			{
				System.out.printf("%7s\n","ERROR");
			}
			else
			{
				System.out.printf("%7s\n",cs);
			}
		}
		sc.close();
	}
}
