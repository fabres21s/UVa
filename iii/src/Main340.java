import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	340 - Master-Mind Hints
*
*
*	Submission:	25140111
*	Date:		2020-06-14 17:52:04
*	Runtime:	0.060
*	Ranking:	4895
*/
public class Main340 {

	/**
	 * - Arreglos
	 * 
	 * Encontrar las coincidencias entre 2 arreglos, primero por posición y luego por valor
	 * 
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int n, x, cases = 0;

		while ((n = Integer.valueOf(br.readLine())) != 0) {
			cases++;
			int[] designer = new int[n];
			int[] originalIncidences = new int[10];
			args = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				x = Integer.valueOf(args[i]);

				designer[i] = x;
				originalIncidences[x]++;
			}

			output.append("Game " + cases + ":\n");
			c: while (true) {
				int[] guess = new int[n];
				int[] incidences = originalIncidences.clone();

				args = br.readLine().split(" ");
				int strongs = 0, weaks = 0;

				for (int i = 0; i < n; i++) {
					x = Integer.valueOf(args[i]);
					if (x == 0)
						break c;
					guess[i] = x;

					if (guess[i] == designer[i]) {
						strongs++;
						incidences[x]--;
						guess[i] = -1;
					}
				}

				for (int i = 0; i < n; i++) {
					if (guess[i] > 0) {
						if (incidences[guess[i]] > 0) {
							incidences[guess[i]]--;
							weaks++;
						}
					}
				}

				output.append("    (" + strongs + "," + weaks + ")\n");

			}
		}
		System.out.print(output);
	}

}
