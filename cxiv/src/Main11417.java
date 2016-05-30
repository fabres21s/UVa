import java.util.Scanner;

/**
*	11417 - GCD
*
*
*	Submision:	9949805
*	Date:		2012-04-03 15:42:59
*	Runtime:	0.380
*	Ranking:	5136
*/
public class Main11417 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, j, n, sum;
		while ((n = input.nextInt()) != 0) {
			sum = 0;
			for (i = 1; i < n; i++)
				for (j = i + 1; j <= n; j++)
					sum += gcd(i, j);
			System.out.println(sum);
		}
		input.close();
		// TODO Auto-generated method stub

	}

	private static int gcd(int a, int b) {
		if (b > 0) {
			return gcd(b, a % b);
		}
		return a;
	}

}
