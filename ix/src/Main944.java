import java.util.Arrays;
import java.util.Scanner;

/**
*	944 - Happy Numbers
*
*
*	Submision:	10734407
*	Date:		2012-10-14 14:40:52
*	Runtime:	0.980
*	Ranking:	549
*/
public class Main944 {

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
		int a, b, i;
		boolean isFirst = true;
		StringBuffer buffer;
		while (input.hasNext()) {
			buffer = new StringBuffer();

			a = input.nextInt();
			b = input.nextInt();
			if (!isFirst)
				System.out.println();
			if (b < a)
				b = a;
			for (i = a; i <= b; i++) {
				happy = false;
				hallarsumatoria(i);
				if (happy) {
					buffer.append(i + " " + ciclos(i) + "\n");
				}
			}
			System.out.print(buffer);
			isFirst = false;
		}
		input.close();
	}

	private static int ciclos(int i) {
		int p = 1, res, sum = 0;
		while (i != 1) {
			sum = 0;
			while (i > 0) {
				res = i % 10;
				sum += res * res;
				i /= 10;
			}
			i = sum;
			p++;
		}
		return p;
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
