import java.util.Scanner;

/**
*	11614 - Etruscan Warriors Never Play Chess
*
*
*	Submission:	9728988
*	Date:		2012-02-10 16:59:33
*	Runtime:	0.340
*	Ranking:	2813
*/
public class Main11614 {

	/**
	 * - Sumatoria de n�meros
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		// long filas[]=new long[200];
		// BigInteger p;
		double p;
		int k = input.nextInt();
		while (k > 0) {
			k--;
			p = input.nextDouble();
			System.out.printf("%.0f\n",
					Math.floor((Math.sqrt(1 + 8 * p) - 1) / 2));
		}
		input.close();

	}

}
