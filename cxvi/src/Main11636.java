import java.util.Scanner;

/**
*	11636 - Hello World!
*
*
*	Submision:	9849628
*	Date:		2012-03-12 16:05:39
*	Runtime:	0.796
*	Ranking:	7133
*/
public class Main11636 {

	/**
	 * - Logaritmos
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double div = Math.log10(2), v;
		int i = 1;
		while ((v = input.nextDouble()) > -1) {
			v = Math.log10(v) / div;
			if (v % 1 != 0)
				v++;
			System.out.printf("Case %d: %d\n", i, (int) v);
			i++;
		}
		input.close();
	}
}
