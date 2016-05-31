import java.util.Scanner;


/**
*	264 - Count on Cantor
*
*
*	Submision:	9260331
*	Date:		2011-09-14 20:28:58
*	Runtime:	0.852
*	Ranking:	7109
*/
public class Main264 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k, r, n;
		while (input.hasNext()) {
			n = input.nextInt();
			k = (int) (Math.sqrt(2 * n) + 0.5);
			r = k * (k + 1) / 2 - n;
			if (k % 2 == 0) {
				System.out.println("TERM " + n + " IS " + (k - r) + "/"
						+ (1 + r));
			} else {
				System.out.println("TERM " + n + " IS " + (1 + r) + "/"
						+ (k - r));
			}
		}
	}

}
