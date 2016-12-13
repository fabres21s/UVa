import java.util.Arrays;
import java.util.Scanner;

/**
*	10474 - Where is the Marble?
*
*
*	Submision:	16047028
*	Date:		2015-09-05 00:28:53
*	Runtime:	2.845
*	Ranking:	6877
*/
public class Main10474 {

	/**
	 * - Arreglos
	 * - Sort
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, q, busq, i, casos = 1;
		int marbles[];

		while (true) {
			n = input.nextInt();
			q = input.nextInt();
			if (n == 0) {
				break;
			}
			marbles = new int[n];
			for (i = 0; i < n; i++)
				marbles[i] = input.nextInt();
			// buffer.append("CASE# "+casos+":\n");
			System.out.printf("CASE# %d:\n", casos);
			Arrays.sort(marbles);
			for (i = 0; i < q; i++) {
				busq = input.nextInt();

				int p = -1;
				for (int k = 0; k < n; k++) {
					if (marbles[k] == busq) {
						p = k + 1;
						break;
					}
					if (marbles[k] > busq) {
						break;
					}
				}

				if (p > -1) {

					// buffer.append(busq+" found at "+(p)+"\n");
					System.out.printf("%d found at %d\n", busq, (p));
				} else {
					// buffer.append(busq+" not found\n");
					System.out.printf("%d not found\n", busq);
				}
			}
			casos++;
		}
		// System.out.println(buffer.toString());
		input.close();
	}
}
