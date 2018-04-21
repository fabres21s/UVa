import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10487 - Closest Sums
*
*	Submission:	20151040
*	Date:		2017-10-10 18:17:57
*	Runtime:	0.160
*	Ranking:	3156
*/
public class Main10487 {

	/**
	 * - Arreglos
	 * 
	 *  Encontrar la suma de n números que más se aproximen a un número dado
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int n, i, x, querys, q, j, sum, min, answer;
		int testCases = 0;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			int array[] = new int[n];
			for (i = 0; i < n; i++) {
				array[i] = Integer.parseInt(br.readLine());
			}
			testCases++;
			output.append("Case "+testCases+":\n");
			querys = Integer.parseInt(br.readLine());
			answer = 0;
			for (x = 1; x <= querys; x++) {
				q = Integer.parseInt(br.readLine());
				min = Integer.MAX_VALUE;
				for (i = 0; i < n; i++) {
					for (j = i + 1; j < n; j++) {
						sum = array[i] + array[j];

						if (Math.abs(sum - q) < min) {
							answer = sum;
							min = Math.abs(sum - q);
						}
					}
				}
				output.append("Closest sum to " + q + " is " + answer + ".\n");
			}

		}
		System.out.print(output);
	}

}
