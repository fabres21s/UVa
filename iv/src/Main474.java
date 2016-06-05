import java.util.Scanner;

/**
*	474 - Heads / Tails Probability
*
*
*	Submision:	9605075
*	Date:		2011-12-31 00:01:09
*	Runtime:	2.272
*	Ranking:	1946
*/
public class Main474 {

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		double digit,n;
		while(input.hasNext())
		{
			n=input.nextDouble();
			digit=Math.floor(Math.log10(2)*n+1);
			System.out.printf("2^-%.0f = %.3fe-%.0f\n", n,Math.pow(2,(digit/Math.log10(2) - n)),digit);
		}
	}
}
