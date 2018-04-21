import java.util.Scanner;

/**
*	11805 - Bafana Bafana
*
*
*	Submission:	9891208
*	Date:		2012-03-21 13:04:08
*	Runtime:	0.592
*	Ranking:	6335
*/
public class Main11805 {

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) {
		int c, res, p, k, n, i;
		Scanner input = new Scanner(System.in);
		c = input.nextInt() + 1;
		for (i = 1; i < c; i++) {
			n = input.nextInt();
			k = input.nextInt();
			p = input.nextInt();
			if (p + k > n)
				res = p + k - n;
			else
				res = p + k;
			while (res > n)
				res -= n;
			System.out.printf("Case %d: %d\n", i, res);
		}
		input.close();
	}

}
