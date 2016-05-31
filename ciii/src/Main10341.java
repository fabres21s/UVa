import java.util.Scanner;

/**
*	10341 - Solve It
*
*
*	Submision:	9566236
*	Date:		2011-12-16 16:06:17
*	Runtime:	2.228
*	Ranking:	4584
*/
public class Main10341 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double p, q, r, s, t, u, a, b = 2, c, fa, fb, fc;
		while (input.hasNext()) {
			p = input.nextDouble();
			q = input.nextDouble();
			r = input.nextDouble();
			s = input.nextDouble();
			t = input.nextDouble();
			u = input.nextDouble();
			a = 0;
			c = 1;
			fa = p * Math.exp(0) + q * Math.sin(0) + r * Math.cos(0) + s
					* Math.tan(0) + u;
			fc = p * Math.exp(-1) + q * Math.sin(1) + r * Math.cos(1) + s
					* Math.tan(1) + t + u;
			if (fa == 0) {
				System.out.println("0.0000");
			} else if (fc == 0) {
				System.out.println("1.0000");
			} else {
				if (fa * fc > 0) {
					System.out.println("No solution");
				} else {
					fb = 2;
					while ((b - a) > 1e-7) {
						b = (a + c) / 2;
						fb = (p * Math.exp(-b) + q * Math.sin(b) + r
								* Math.cos(b) + s * Math.tan(b) + t * b * b + u);
						if (fa * fb < 0) {
							c = b;
						} else {
							a = b;
							b = c;
						}
					}
					System.out.printf("%.4f\n", b);
				}
			}
		}
		input.close();
	}
}
