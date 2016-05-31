import java.util.Arrays;
import java.util.Scanner;

/**
*	10591 - Happy Number
*
*
*	Submision:	9567026
*	Date:		2011-12-16 20:43:22
*	Runtime:	1.192
*	Ranking:	5567
*/
public class Main10591 {
	static final long happynumbers[] = { 1, 7, 10, 13, 19, 23, 28, 31, 32, 44,
			49, 68, 70, 79, 82, 86, 91, 94, 97, 100, 103, 109, 129, 130, 133,
			139, 167, 176, 188, 190, 192, 193, 203, 208, 219, 226, 230, 236,
			239, 262, 263, 280, 291, 293, 301, 302, 310, 313, 319, 320, 326,
			329, 331, 338, 356, 362, 365, 367, 368, 376, 379, 383, 386, 391,
			392, 397, 404, 409, 440, 446, 464, 469, 478, 487, 490, 496 };
	static boolean happy;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt() + 1, i;
		long n;
		for (i = 1; i < casos; i++) {
			happy = false;
			n = input.nextLong();
			hallarsumatoria(n);
			if (happy) {
				System.out.printf("Case #%d: %d is a Happy number.\n", i, n);
			} else {
				System.out.printf("Case #%d: %d is an Unhappy number.\n", i, n);
			}
		}
		input.close();
	}

	static void hallarsumatoria(long n) {

		int aux = Arrays.binarySearch(happynumbers, n);
		if (n < 496 && aux < 0) {
			return;
		}
		if (aux > -1) {
			happy = true;
			return;
		}
		long sum = 0, res;
		while (n > 0) {
			res = n % 10;
			sum += res * res;
			n /= 10;
		}
		hallarsumatoria(sum);
	}
}
