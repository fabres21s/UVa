import java.util.Scanner;

/**
*	10784 - Diagonal
*
*
*	Submision:	9330178
*	Date:		2011-10-03 14:35:54
*	Runtime:	0.320
*	Ranking:	3535
*/
public class Main10784 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long N, n;
		long C = 1;
		Scanner in = new Scanner(System.in);
		while (true) {
			N = in.nextLong();
			if (N == 0)
				break;
			n = (long) (3 + Math.sqrt(9.0 + 8.0 * (N - 1))) / 2;
			System.out.println("Case " + C + ": " + (n + 1));
			C++;
		}
		in.close();
	}
}
