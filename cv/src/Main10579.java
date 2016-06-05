import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
*	10579 - Fibonacci Numbers
*
*
*	Submision:	9411151
*	Date:		2011-10-26 15:00:36
*	Runtime:	0.212
*	Ranking:	3127
*/
public class Main10579 {

	/**
	 * - Pregenerados
	 * - Fibonacci
	 */
	public static void main(String[] args) throws IOException {
		BigInteger[] fibos = new BigInteger[5005];
		Scanner input = new Scanner(System.in);
		int i;
		fibos[0] = BigInteger.ZERO;
		fibos[1] = BigInteger.ONE;
		for (i = 2; i < 5005; i++) {
			// System.out.println(fibos[i-1]);
			fibos[i] = fibos[i - 1].add(fibos[i - 2]);
			// System.out.println(fibos[i]);
		}
		while (input.hasNext()) {
			i = input.nextInt();
			if (i < 0) {
				continue;
			}
			System.out.println(fibos[i]);
		}
		input.close();
	}
}