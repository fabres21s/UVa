import java.io.IOException;
import java.util.Scanner;

/**
*	10970 - Big Chocolate
*
*
*	Submission:	9513276
*	Date:		2011-11-28 01:52:47
*	Runtime:	2.716
*	Ranking:	10679
*/
public class Main10970 {

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int m, n;
		while (input.hasNext()) {
			m = input.nextInt();
			n = input.nextInt();
			System.out.printf("%d\n", m * n - 1);
		}
		input.close();
	}
}
