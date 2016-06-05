import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


/**
*	763 - Fibinary Numbers
*
*
*	Submision:	16040469
*	Date:		2015-09-03 17:13:45
*	Runtime:	0.646
*	Ranking:	662
*/
public class Main763 {
	static BigInteger[] fibos = new BigInteger[120];

	/**
	 * - Pregenerados
	 * - Fibonacci
	 * - Big Numbers
	 */
	public static void main(String[] args) throws IOException {
		generar();
		Scanner input = new Scanner(System.in);
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		String m, n;
		//
		// FileWriter file = new FileWriter("output.txt", false);
		// PrintWriter pw = new PrintWriter(file);
		while (input.hasNext()) {
			m = input.next();
			n = input.next();

			if (i > 0) {
				System.out.println();
			}
			i++;

			System.out.println(fibonaccimal(decimal(m.toCharArray(), 0).add(
					decimal(n.toCharArray(), 1))));

			//
			// if(i ==5){
			// break;
			// }
		}
		// pw.close();
		input.close();
	}

	private static String fibonaccimal(BigInteger n) {
		// System.out.println("valor a convertir "+n);

		StringBuffer buffer = new StringBuffer();
		int i = 0;
		while (n.compareTo(fibos[i]) >= 0) {
			// System.out.println(fibos[i]+" "+n);
			i++;
		}

		i--;
		while (i > -1) {
			if (n.compareTo(fibos[i]) == 0 || n.compareTo(fibos[i]) == 1)
			// if((n-fibos[i])>=0)
			{
				n = n.subtract(fibos[i]);
				// n-=fibos[i];
				buffer.append("1");
			} else
				buffer.append("0");
			i--;
		}
		if (buffer.length() == 0)
			return "0";
		return buffer.toString();
	}

	private static BigInteger decimal(char[] p, int x) {

		BigInteger n = BigInteger.ZERO;
		int j = 0;
		for (int i = p.length - 1; i > -1; i--) {
			n = n.add(fibos[j].multiply(BigInteger.valueOf((long) (p[i] - 48))));
			j++;
		}
		// System.out.println("retornando "+n);
		return n;
	}

	private static void generar() {
		fibos[0] = BigInteger.ONE;
		fibos[1] = fibos[0].add(BigInteger.ONE);
		for (int i = 2; i < 120; i++) {
			fibos[i] = fibos[i - 1].add(fibos[i - 2]);
			// System.out.println(i+" "+fibos[i]);
		}

	}
}
