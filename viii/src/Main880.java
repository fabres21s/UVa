import java.util.Scanner;

/**
*	880 - Cantor Fractions
*
*
*	Submision:	9574953
*	Date:		2011-12-19 13:50:10
*	Runtime:	2.060
*	Ranking:	1414
*/
public class Main880 {

	/**
	 * - Sumatoria de números
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long x, y, n;
		while (input.hasNext()) {
			n = input.nextLong();
			x = (long) (Math.sqrt(1 + 8 * n) - 1) / 2;
			y = x * (x + 1) / 2;
			if (y == n) {
				System.out.println("1/" + x);
			} else {
				System.out.println(((x + 1) - (n - y) + 1) + "/" + (n - y));
			}
			// if(k % 2==0)
			// {
			// System.out.println((k-r)+"/"+(1+r));
			// }
			// else
			// {
			// System.out.println((1+r)+"/"+(k-r));
			// }
		}

	}

}
