import java.util.Scanner;

/**
*	10916 - Factstone Benchmark
*
*
*	Submission:	9618315
*	Date:		2012-01-04 20:14:49
*	Runtime:	0.372
*	Ranking:	1408
*/
public class Main10916 {

	/**
	 * - Logaritmos
	 */
	public static void main(String[] args) {
		int y, i;
		double w, f;
		Scanner input = new Scanner(System.in);
		while ((y = input.nextInt()) != 0) {
			w = Math.log(4);
			for (i = 1960; i <= y; i += 10) {
				w *= 2;
			}
			f = 0;
			i = 1;
			while (f < w) {
				f += Math.log((double) ++i);
			}
			System.out.println((i - 1));
		}
		input.close();
	}
}
