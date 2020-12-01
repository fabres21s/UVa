import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10773 - Back to Intermediate Math
*
*	Submission:	25793809
*	Date:		2020-12-01 20:33:11
*	Runtime:	0.060
*	Ranking:	5496 / 5704
*/
public class Main10773 {

	/**
	 * - Fórmulas
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder output = new StringBuilder();

		int testCases = Integer.parseInt(br.readLine());

		double d, u, v;
		double t1, t2, t3;
		for (int i = 1; i <= testCases; i++) {
			args = br.readLine().split(" ");

			d = Double.parseDouble(args[0]);
			v = Double.parseDouble(args[1]);
			u = Double.parseDouble(args[2]);

			if (v >= u) {
				output.append(String.format("Case %d: can't determine\n", i));
			} else {
				t1 = d / u;
				t2 = d / (Math.sqrt(u * u - v * v));

				t3 = t2 - t1;
				if (t3 <= 0) {
					output.append(String.format("Case %d: can't determine\n", i));
				} else {
					output.append(String.format("Case %d: %.03f\n", i, t3));
				}
			}

		}
		System.out.print(output);
	}

}
