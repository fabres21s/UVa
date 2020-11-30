import java.util.Scanner;

/**
*	10499 - The Land of Justice
*
*
*	Submission:	9615864
*	Date:		2012-01-03 23:09:19
*	Runtime:	1.116
*	Ranking:	6628 / 6733
*/
public class Main10499 {

	/**
	 * - Muy f�cil
	 */
	public static void main(String[] args) {
		long n;
		Scanner input = new Scanner(System.in);
		while ((n = input.nextLong()) > -1) {
			if (n == 1) {
				System.out.println("0%");
				continue;
			}
			System.out.println(n * 25 + "%");
		}
		input.close();
	}
}
