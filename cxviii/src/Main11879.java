import java.math.BigInteger;
import java.util.Scanner;

/**
*	11879 - Multiple of 17
*
*
*	Submision:	9508741
*	Date:		2011-11-26 16:15:11
*	Runtime:	0.128
*	Ranking:	2476
*/
public class Main11879 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger n, q, x;
		q = BigInteger.ZERO;
		x = BigInteger.valueOf(17);
		while (!(n = input.nextBigInteger()).equals(q)) {
			if (n.mod(x) == q) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
		// TODO Auto-generated method stub

	}

}
