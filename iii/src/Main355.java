import java.math.BigInteger;
import java.util.Scanner;

/**
*	355 - The Bases Are Loaded
*
*
*	Submission:	9342785
*	Date:		2011-10-07 02:14:40
*	Runtime:	0.644
*	Ranking:	2828
*/
public class Main355 {

	/**
	 * - Sistemas de numeración
	 */
	public static void main(String[] args) {
		String s, cs;
		int b, t;
		BigInteger a;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			b = sc.nextInt();// base inicial
			t = sc.nextInt();// base final
			s = sc.next();// valor
			try {
				a = new BigInteger(s, b);
				cs = a.toString(t).toUpperCase();
				System.out.printf("%s base %d = %s base %d%n", s, b, cs, t);
			} catch (Exception ex) {
				System.out.printf("%s is an illegal base %d number%n", s, b);
			}
		}
		sc.close();
	}
}
