import java.util.Scanner;

/**
*	10346 - Peter's Smokes
*
*
*	Submission:	9567556
*	Date:		2011-12-17 01:09:54
*	Runtime:	0.420
*	Ranking:	17018 / 17511
*/
public class Main10346 {

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, k;
		while (input.hasNext()) {
			n = input.nextInt();
			k = input.nextInt();
			System.out.println((n + (n - 1) / (k - 1)));
		}
		input.close();
	}
}
