import java.util.Scanner;

/**
*	10077 - The Stern-Brocot Number System
*
*
*	Submission:	9306778
*	Date:		2011-09-27 20:27:50
*	Runtime:	1.052
*	Ranking:	4941 / 5017 
*/
public class Main10077 {

	/**
	 * - Sistemas de numeración
	 * 
	 * Llevas un número al sistema de numeración Stern-Brocot
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			Scanner ls = new Scanner(s.nextLine());
			long m = ls.nextLong();
			long n = ls.nextLong();
			if (((m == 1) && (n == 1))) {
				break;
			}
			long leftm = 0;
			long leftn = 1;
			long rightm = 1;
			long rightn = 0;
			StringBuffer output = new StringBuffer();
			while (true) {
				long mtest = leftm + rightm;
				long ntest = leftn + rightn;
				if (m * ntest == mtest * n) {
					System.out.println(output);
					break;
				}
				if (m * ntest < mtest * n) {
					rightm = mtest;
					rightn = ntest;
					output.append("L");
				} else {
					leftm = mtest;
					leftn = ntest;
					output.append("R");
				}
			}
			ls.close();
		}
		s.close();
	}
}
