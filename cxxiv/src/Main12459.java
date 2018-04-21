import java.util.Scanner;

/**
*	12459 - Bees' ancestors
*
*
*	Submission:	12306544
*	Date:		2013-09-06 16:43:09
*	Runtime:	0.169
*	Ranking:	1751
*/
public class Main12459 {

	/**
	 * - Pregenerados
	 */
	public static void main(String[] args) {
		long x[] = new long[85];
		long y[] = new long[85];

		x[1] = 1;
		y[1] = 0;

		for (int i = 2; i <= 80; ++i) {
			x[i] = x[i - 1] + y[i - 1];
			y[i] = x[i - 1];
		}
		Scanner input = new Scanner(System.in);
		int c;
		while ((c = input.nextInt()) != 0) {
			System.out.println(x[c] + y[c]);
		}
		input.close();

	}

}
