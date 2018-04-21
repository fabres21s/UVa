import java.util.Scanner;

/**
*	679 - Dropping Balls
*
*
*	Submission:	9673692
*	Date:		2012-01-25 02:36:11
*	Runtime:	1.908
*	Ranking:	2858
*/
public class Main679 {

	/**
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int kase, D, L, p, i;
		while ((kase = input.nextInt()) != -1) {
			while (kase > 0) {
				kase--;
				D = input.nextInt();
				L = input.nextInt();
				p = 1;
				for (i = 0; i < D - 1; i++) {
					if (L % 2 != 0) {
						p = 2 * p;
					} else {
						p = 2 * p + 1;
					}
					L = (L + 1) / 2;
				}
				System.out.println(p);
			}
		}
		input.close();
	}

}
