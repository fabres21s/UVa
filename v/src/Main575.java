import java.util.Scanner;

/**
*	575 - Skew Binary
*
*
*	Submision:	9705781
*	Date:		2012-02-03 16:10:09
*	Runtime:	0.128
*	Ranking:	11538
*/
public class Main575 {

	/**
	 * - Potencias
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String[] p = input.next().split("");
			int sum = 0;
			int exp = p.length - 1;
			for (int i = 1; i < p.length; i++) {
				sum += Integer.valueOf(p[i]) * (Math.pow(2, exp) - 1);
				exp--;
			}
			System.out.println(sum);
		}
	}
}
