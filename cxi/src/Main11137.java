import java.util.Scanner;

/**
*	11137 - Ingenuous Cubrency
*
*	Submission:	21310286
*	Date:		2018-05-14 13:39:36
*	Runtime:	0.100
*	Ranking:	3749
*/
public class Main11137 {
	static int MAXTOTAL = 10001;
	static long[] nways = new long[MAXTOTAL];
	static long coin[] = { 1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728, 2197, 2744, 3375, 4096, 4913, 5832,
			6859, 8000, 9261, 10648 };

	/**
	 * - Pregenerados
	 * 
	 *  Encontrar de cuántas maneras se puede tener cierta cantidad de dinero
	 *  dependiendo de las monedas disponibles
	 */
	public static void main(String[] args) {

		int n;
		calcular();
		StringBuffer output = new StringBuffer();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			n = input.nextInt();
			output.append(nways[n]);
			output.append("\n");
		}
		System.out.print(output);
		input.close();
	}

	private static void calcular() {
		int i, j, v = 21, aux;
		long c;
		nways[0] = 1;
		for (i = 0; i < v; i++) {
			c = coin[i];
			aux = (int) c;
			for (j = aux; j < 10000; j++) {
				nways[j] += nways[j - aux];
			}
		}
	}
}
