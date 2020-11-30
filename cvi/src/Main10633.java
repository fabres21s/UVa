import java.math.BigInteger;
import java.util.Scanner;

/**
*	10633 - Rare Easy Problem
*
*
*	Submission:	9618404
*	Date:		2012-01-04 20:43:40
*	Runtime:	0.248
*	Ranking:	3160 / 3201
*/
public class Main10633 {

	/**
	 * - Big Numbers
	 */
	public static void main(String[] args) {
		BigInteger d, x, y, a = BigInteger.valueOf(9), b = BigInteger
				.valueOf(10);
		Scanner input = new Scanner(System.in);
		long m;
		while (!(d = input.nextBigInteger()).equals(0)) {
			if (d.compareTo(BigInteger.ZERO) == 0) {
				break;
			}
			m = Long.valueOf(d.mod(a).longValue());
			x = d.multiply(b);
			y = x.divide(a);
			// System.out.println("mm "+m);
			if (m == 0) {
				System.out.println((y.longValue() - 1) + " " + y);
			} else {
				System.out.println(y);
			}
		}
		input.close();

	}

}
