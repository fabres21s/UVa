import java.math.BigInteger;
import java.util.Scanner;


/**
*	369 - Combinations
*
*
*	Submision:	9709941
*	Date:		2012-02-05 00:50:10
*	Runtime:	0.652
*	Ranking:	10071
*/
public class Main369 {
	static BigInteger facts[] = new BigInteger[105];

	/**
	 * - Pregenerados
	 * - Factorial
	 * - Big Numbers
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, m;
		facts[0] = new BigInteger("1");
		facts[1] = new BigInteger("1");
		facts[2] = new BigInteger("2");
		crear();
		while (input.hasNext()) {
			n = input.nextInt();
			m = input.nextInt();
			if (n == 0 && m == 0) {
				break;
			}
			System.out.println(n + " things taken " + m + " at a time is "
					+ facts[n].divide(facts[n - m].multiply(facts[m]))
					+ " exactly.");
			// System.out.printf("%d!\n%d\n", n,fact(n));
		}
		input.close();

	}

	public static void crear() {
		for (int i = 3; i < 102; i++) {

			facts[i] = (new BigInteger(i + "")).multiply(facts[i - 1]);
		}
		// System.out.println(facts[100]);
	}

}
