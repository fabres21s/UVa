import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10891 - Game of Sum
*
*	Submission:	21182865
*	Date:		2018-04-22 00:07:07
*	Runtime:	0.080
*	Ranking:	1690 / 2551
*/
public class Main10891 {

	/**
	 * - Programación Dinámica
	 * 
	 *  Encontrar la suma máxima en un arreglo, tomando por los dos extremos
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int n, best, j, d, i;
		int array[] = new int[111];
		while ((n = Integer.parseInt(br.readLine())) > 0) {
			args = br.readLine().split(" ");

			for (i = 1; i <= n; i++) {
				array[i] = array[i - 1] + Integer.parseInt(args[i - 1]);
			}

			int game[][] = new int[111][111];
			for (d = 0; d < n; d++) {
				for (i = 1; i <= n - d; i++) {
					j = i + d;
					best = Integer.MIN_VALUE;
					for (int k = i; k <= j; k++) {
						// take from i to k
						if (array[k] - array[i - 1] - game[k + 1][j] > best)
							best = array[k] - array[i - 1] - game[k + 1][j];
						// take from k to j
						if (array[j] - array[k - 1] - game[i][k - 1] > best)
							best = array[j] - array[k - 1] - game[i][k - 1];
					}
					game[i][j] = best;
				}
			}
			output.append(game[1][n] + "\n");

		}
		System.out.print(output);

	}

}
