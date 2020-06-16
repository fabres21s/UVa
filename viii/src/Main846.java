import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	846 - Steps
*
*
*	Submission:	25146486
*	Date:		2020-06-16 23:27:16
*	Runtime:	0.120
*	Ranking:	5155
*/
public class Main846 {

	/**
	 * - Sumatoria de números
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.valueOf(br.readLine().trim());

		long start, end, n = 0, diff, k, x;
		while (testCases-- > 0) {

			args = br.readLine().trim().split(" ");

			start = Integer.valueOf(args[0]);
			end = Integer.valueOf(args[1]);

			diff = (end - start);

			k = (int) ((-1 + Math.sqrt(1 + 4 * diff)) / 2);

			n = k * (k + 1) / 2;

			x = diff - 2 * n;

			if (x == 0) {
				k = k * 2;
			} else if (x > k + 1) {
				k = k * 2 + 2;
			} else {
				k = k * 2 + 1;
			}

			System.out.println(k);
		}
	}

}
