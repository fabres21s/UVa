import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	507 - Permutation Arrays
*
*
*	Submission:	25143414
*	Date:		2020-06-15 19:35:10
*	Runtime:	0.310
*	Ranking:	4998
*/
public class Main507 {

	/**
	 * - Arreglos
	 * 
	 * - Encontrar el rango de la máxima sumatoria en un arreglo
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.valueOf(br.readLine().trim());

		for (int cases = 1; cases <= testCases; cases++) {
			int stops = Integer.valueOf(br.readLine().trim()) - 1;

			int[] array = new int[stops];
			int[] sumatoria = new int[stops];
			int sum = 0, max = 0, iAns = 0, jAns = 0;

			for (int i = 0; i < stops; i++) {
				array[i] = Integer.valueOf(br.readLine().trim());
				sum += array[i];

				sumatoria[i] = sum;

				if (sum >= max) {
					max = sum;
				}
				if (sum < 0) {
					sum = 0;
				}
			}

			int endMax = 0, startMax = 0;
			for (int i = 0; i < stops; i++) {

				boolean isValid = false;
				startMax = i;

				while (i < stops && sumatoria[i] >= 0) {
					if (sumatoria[i] == max) {
						isValid = true;
						endMax = i + 1;
					}
					i++;
				}

				if (isValid) {
					if ((endMax - startMax) > (jAns - iAns)) {
						jAns = endMax + 1;
						iAns = startMax + 1;
					}
				}
			}

			if (max > 0) {
				System.out.printf("The nicest part of route %d is between stops %d and %d\n", cases, (iAns), (jAns));
			} else {
				System.out.printf("Route %d has no nice parts\n", cases);
			}

		}
	}

}
