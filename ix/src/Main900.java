import java.util.Scanner;

/**
*	900 - Brick Wall Patterns
*
*
*	Submision:	9573800
*	Date:		2011-12-19 05:03:14
*	Runtime:	0.256
*	Ranking:	6403
*/
public class Main900 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long fibos[] = new long[55];
		int i;
		fibos[1] = 1;
		fibos[2] = 2;
		for (i = 3; i < 52; i++) {
			fibos[i] = fibos[i - 1] + fibos[i - 2];
		}
		while ((i = input.nextInt()) != 0) {
			System.out.println(fibos[i]);
		}
	}
}
