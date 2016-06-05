import java.math.BigInteger;
import java.util.Scanner;

/**
*	623 - 500!
*
*
*	Submision:	9497087
*	Date:		2011-11-22 21:34:20
*	Runtime:	1.816
*	Ranking:	5852
*/
public class Main623 {
	static BigInteger facts[] = new BigInteger[1005];

	/**
	 * - Factorial
	 * - Big Numbers
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		facts[0] = new BigInteger("1");
		facts[1] = new BigInteger("1");
		facts[2] = new BigInteger("2");
		while (input.hasNext()) {
			n = input.nextInt();
			System.out.printf("%d!\n%d\n", n, fact(n));
		}

	}

	public static BigInteger fact(int n) {
		if (facts[n] != null) {
			return facts[n];
		} else
			return facts[n] = (new BigInteger(n + "")).multiply(fact(n - 1));
	}

}
