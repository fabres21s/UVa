import java.math.BigInteger;
import java.util.Scanner;

/**
*	10494 - If We Were a Child Again
*
*
*	Submission:	9489011
*	Date:		2011-11-20 00:45:09
*	Runtime:	0.244
*	Ranking:	3867 / 3996
*/
public class Main10494 {

	/**
	 * - Big Numbers
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger a, b;
		String op;
		while (input.hasNext()) {
			a = input.nextBigInteger();
			op = input.next();
			b = input.nextBigInteger();
			if (op.equals("%")) {
				System.out.println(a.mod(b));
			} else {
				System.out.println(a.divide(b));
			}
		}
		input.close();
	}
}
