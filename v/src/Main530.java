import java.util.Scanner;

/**
*	530 - Binomial Showdown
*
*
*	Submision:	9605076
*	Date:		2011-12-31 00:01:11
*	Runtime:	0.152
*	Ranking:	6908
*/
public class Main530 {

	/**
	 * - GCD
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n, k, j, d, g, res;
		int i;
		long a[];
		while (true) {
			n = input.nextLong();
			k = input.nextLong();
			if (n == 0 && k == n) {
				break;
			}
			a = new long[20];
			if (k > n / 2) {
				k = n - k;
			}
			for (i = 0; i < k; i++) {
				a[i] = n - i;
			}
			for (j = 2; j <= k; j++) {
				for (i = 0, d = j; d > 1; i++) {
					g = gcd(a[i], d);
					a[i] /= g;
					d /= g;
				}
			}
			for (i = 0, res = 1; i < k; res *= a[i++])
				;
			System.out.println(res);
		}
	}

	private static long gcd(long a, long b) {
		if (b > 0) {
			return gcd(b, a % b);
		}
		return a;
	}
}
