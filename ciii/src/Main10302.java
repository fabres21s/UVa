import java.math.BigInteger;
import java.util.Scanner;

/**
*	10302 - Summation of Polynomials
*
*
*	Submision:	9565922
*	Date:		2011-12-16 14:17:58
*	Runtime:	0.400
*	Ranking:	7110
*/
public class Main10302 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger x;
		long n;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			n = input.nextLong();
			n = n * (n + 1) / 2;
			x = BigInteger.valueOf(n).pow(2);
			System.out.println(x);
		}
		input.close();
	}
}
