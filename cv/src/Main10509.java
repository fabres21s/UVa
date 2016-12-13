import java.util.Scanner;

/**
*	10509 - R U Kidding Mr. Feynman?
*
*
*	Submision:	9673680
*	Date:		2012-01-25 02:28:16
*	Runtime:	2.808
*	Ranking:	1730
*/
public class Main10509 {

	/**
	 * - Fórmula
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner (System.in);
		double n,dx,a;
		while((n=input.nextDouble())!=0)
		{
			a=(int) Math.cbrt(n);
			//a=r;
			//System.out.println("raiz "+r);
			if(a*a*a==n)
			{
				System.out.printf("%.4f\n",a);
				continue;
			}
			dx=(n-a*a*a)/(3*a*a);
			System.out.printf("%.4f\n",(a+dx));
		}
		input.close();

	}

}
