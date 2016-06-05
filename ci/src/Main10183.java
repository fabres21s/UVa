import java.math.BigInteger;
import java.util.Scanner;

/**
*	10183 - How Many Fibs?
*
*
*	Submision:	9243245
*	Date:		2011-09-09 19:46:14
*	Runtime:	0.768
*	Ranking:	3756
*/
public class Main10183 {

	/**
	 * - Fibonacci
	 * - Big Numbers
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			// BigInteger a = input.nextBigInteger();
			// BigInteger b = input.nextBigInteger();
			/*
			 * if (a.compareTo(BigInteger.ONE) == -1 &&
			 * b.compareTo(BigInteger.ONE) == -1) { break; }
			 */
			// int count = 0;
			BigInteger[] fibos = new BigInteger[1000000];
			fibos[0] = BigInteger.ONE;
			int i;
			String p = input.next();
			fibos[1] = BigInteger.ONE.add(BigInteger.ONE);
			for (i = 2; i < fibos.length; i++) {
				fibos[i] = fibos[i - 1].add(fibos[i - 2]);

				if (fibos[i].toString().startsWith(p)) {
					break;
				}

			}
			System.out.println(fibos[i] + "   " + (i + 1));
		}
		input.close();
	}
}
