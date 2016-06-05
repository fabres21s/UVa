import java.util.Scanner;

/**
*	12114 - Bachelor Arithmetic
*
*
*	Submision:	16495201
*	Date:		2015-11-26 14:18:28
*	Runtime:	0.235
*	Ranking:	903
*/
public class Main12114 {

	/**
	 * - Validaciones
	 */
	public static void main(String[] args) {
		// b y s s/b
		Scanner input = new Scanner(System.in);
		double b, s;
		double r1, r2 = 0;
		int casos = 0;
		while (input.hasNext()) {
			b = input.nextDouble();
			s = input.nextDouble();
			
			if (b == 0 && s == 0) {
				break;
			}
			casos++;
			r1 = s / b;

			if (b > 1) {
				r2 = (s - 1) / (b - 1);
			} else {
				System.out.println("Case " + casos + ": :-\\");
				continue;
			}
			if (r2 > r1 || r2 == r1) {
				System.out.println("Case " + casos + ": :-|");
			} else {
				System.out.println("Case " + casos + ": :-(");
			}
			
		}
		input.close();
	}

}






