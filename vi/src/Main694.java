import java.util.Scanner;

/**
*	694 - The Collatz Sequence
*
*
*	Submision:	9582142
*	Date:		2011-12-21 21:35:45
*	Runtime:	0.992
*	Ranking:	9389
*/
public class Main694 {

	/**
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = 0;
		long a, l;
		while (input.hasNext()) {
			casos++;
			a = input.nextLong();
			l = input.nextLong();
			if (a < 0 | l < 0) {
				break;
			}
			System.out.println("Case " + casos + ": A = " + a + ", limit = "
					+ l + ", number of terms = " + computeItems(a, l));
		}

	}

	static int computeItems(long a, long limit) {

		int count = 1;
		while (a > 1 && a <= limit) {
			if (a % 2 == 0) {
				a = a / 2;
			} else {
				a = 3 * a + 1;
			}
			// a = ((a & 1) == 0) ? a >> 1 : (3 * a + 1);
			if (a > limit) {
				return count;
			}
			count++;
		}
		return count;
	}
}
