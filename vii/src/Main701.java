import java.util.Scanner;

/**
*	701 - The Archeologists' Dilemma
*
*
*	Submision:	9242745
*	Date:		2011-09-09 16:51:32
*	Runtime:	0.476
*	Ranking:	1504
*/
public class Main701 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n, e, k;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			n = input.nextInt();
			for (e = 1;; e++) {
				k = (int) (Math.floor(e * Math.log10(2)) - Math.floor(Math
						.log10(n)));
				if (k <= Math.floor(Math.log10(n)) + 1) {
					continue;
				}
				if (log2(n) + k * log2(10) <= e
						&& e < log2(n + 1) + k * log2(10)) {
					System.out.println(e);
					break;
				}
			}
		}


	}

	static double log2(int n) {
		return Math.log10(n) / Math.log10(2);
	}

}
