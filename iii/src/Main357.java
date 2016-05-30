import java.util.Scanner;


/**
*	357 - Let Me Count The Ways
*
*
*	Submision:	9605073
*	Date:		2011-12-31 00:01:07
*	Runtime:	1.396
*	Ranking:	7489
*/
public class Main357 {
	static int MAXTOTAL = 30002;
	static long[] nways = new long[MAXTOTAL];
	static long coin[] = { 50, 25, 10, 5, 1 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n;
		calcular();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			n = input.nextInt();
			if (nways[n] > 1) {
				System.out.printf(
						"There are %d ways to produce %d cents change.\n",
						nways[n], n);
			} else {
				System.out.printf(
						"There is only 1 way to produce %d cents change.\n", n);
			}
		}
		// TODO Auto-generated method stub
	}

	private static void calcular() {
		int i, j, v = 5, aux;
		long c;
		nways[0] = 1;
		for (i = 0; i < v; i++) {
			c = coin[i];
			aux = (int) c;
			for (j = aux; j < 30001; j++) {
				nways[j] += nways[j - aux];
			}
		}
		// TODO Auto-generated method stub
	}
}
