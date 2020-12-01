import java.util.Scanner;

/**
*	10771 - Barbarian tribes
*
*
*	Submision:	9605086
*	Date:		2011-12-31 00:03:56
*	Runtime:	0.872
*	Ranking:	568 / 597
*/
public class Main10771 {

	/**
	 * - Muy fácil
	 */
	public static void main(String[] args) {
		int n, m, k;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			n = input.nextInt();
			m = input.nextInt();
			k = input.nextInt();
			if (n == 0 && m == 0 && k == 0) {
				break;
			}
			if (m % 2 == 0) {
				System.out.println("Gared");
			} else {
				System.out.println("Keka");
			}
		}
		input.close();
	}
}
