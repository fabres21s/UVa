import java.util.Scanner;

/**
*	11780 - Miles 2 Km
*
*
*	Submission:	9411270
*	Date:		2011-10-26 15:31:43
*	Runtime:	0.464
*	Ranking:	439
*/
public class Main11780 {

	/**
	 * - Proceso matem�tico
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		while ((n = input.nextInt()) != 0) {
			double a = (int) (1.6 * n);
			double b = a + 1;
			System.out.printf("%.2f\n", Math.min(1.6 * n - a, b - 1.6 * n));
		}
		input.close();
	}
}