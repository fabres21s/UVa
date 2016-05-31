import java.util.Scanner;

/**
*	11054 - Wine trading in Gergovia
*
*
*	Submision:	9618281
*	Date:		2012-01-04 20:03:54
*	Runtime:	0.880
*	Ranking:	1949
*/
public class Main11054 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long n, m, k, i, d;
		Scanner input = new Scanner(System.in);
		while ((n = input.nextLong()) != 0) {
			k = d = 0;
			for (i = 0; i < n; i++) {
				m = input.nextLong();
				k += Math.abs(d);
				d += m;
			}
			System.out.println(k);
		}
		input.close();
	}
}
