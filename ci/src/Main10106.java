import java.math.BigInteger;
import java.util.Scanner;

/**
*	10106 - Product
*
*
*	Submission:	9438902
*	Date:		2011-11-03 21:19:43
*	Runtime:	0.156
*	Ranking:	10388 / 11837
*/
public class Main10106 {

	/**
	 * - Big Numbers
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger a, b;
		while (input.hasNext()) {
			a = input.nextBigInteger();
			b = input.nextBigInteger();
			System.out.println(a.multiply(b));
		}
		input.close();
	}
}
