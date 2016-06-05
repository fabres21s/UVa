import java.util.Arrays;
import java.util.Scanner;

/**
*	10539 - Almost Prime Numbers
*
*
*	Submision:	9330191
*	Date:		2011-10-03 14:40:52
*	Runtime:	0.356
*	Ranking:	1435
*/
public class Main10539 {
	static long[] A = new long[80070];

	/**
	 * - Pregenerados
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N;
		long low, high;
		int lowPs, highPs;
		generate();
		N = in.nextInt();
		while ((N--) > 0) {
			low = in.nextLong();
			high = in.nextLong();
			lowPs = Arrays.binarySearch(A, low);
			if (lowPs < 0)
				lowPs = (-1) * (lowPs + 1);
			highPs = Arrays.binarySearch(A, high);
			if (highPs < 0)
				highPs = (-1) * (highPs + 2);
			System.out.println(highPs - lowPs + 1);
		}
		in.close();

	}

	static void generate() {
		boolean[] P = new boolean[1000000];
		long LIMIT = (long) Math.pow(10.0, 12);
		int i, k;
		long j, m;
		for (i = 2; i < 1000; i++) {
			if (P[i] == false) {
				for (j = i + i; j < 1000000; j += i) {
					P[(int) j] = true;
				}
			}
		}
		k = 0;
		for (i = 2; i < 1000000; i++) {
			if (P[i] == false) {
				m = (long) i;
				for (j = m * m; j < LIMIT; j *= m) {
					A[k++] = j;
				}
			}
		}
		Arrays.sort(A);
	}
}
