import java.math.BigInteger;
import java.util.Scanner;

/**
*	10931 - Parity
*
*
*	Submission:	9546915
*	Date:		2011-12-09 22:27:58
*	Runtime:	0.332
*	Ranking:	6649
*/
public class Main10931 {

	/**
	 * - Big Numbers
	 * - Sistemas de numeraci�n
	 */
	public static void main(String[] args) {
		String s, cs;
		int b, t;
		BigInteger a;
		b = 10;
		t = 2;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

			s = sc.next();
			if (s.equals("0")) {
				break;
			}
			a = new BigInteger(s, b);
			cs = a.toString(t);
			System.out.println("The parity of " + cs + " is " + contarunos(cs)
					+ " (mod 2).");
		}
		sc.close();
	}

	static int contarunos(String linea) {
		char[] p = linea.toCharArray();
		int c = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] == '1') {
				c++;
			}
		}
		return c;
	}
}
