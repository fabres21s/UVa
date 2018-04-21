import java.util.Scanner;

/**
*	10079 - Pizza Cutting
*
*
*	Submission:	9578637
*	Date:		2011-12-21 01:03:32
*	Runtime:	0.120
*	Ranking:	10191
*/
public class Main10079 {

	/**
	 * - Sumatoria de n�meros
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n;
		while ((n = input.nextLong()) > -1) {
			n = n * (n + 1) / 2 + 1;
			System.out.println(n);
		}
		input.close();
	}
}
