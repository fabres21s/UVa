import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10324 - Zeros and Ones
*
*
*	Submission:	18499659
*	Date:		2016-12-14 15:49:52
*	Runtime:	2.410
*	Ranking:	8076 / 8983
*/
public class Main10324 {

	/**
	 * - Cadena de caracteres
	 * 
	 *  En una cadena de caracteres y dados un inicio y un fin
	 *  determinar si en ese rango, los caracteres son los mismos
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int testCases = 1, tests;
		int m, n, start, end;
		while ((line = br.readLine()) != null) {
			tests = Integer.parseInt(br.readLine());
			System.out.println("Case " + testCases + ":");
			testCases++;
			for (int i = 0; i < tests; i++) {
				args = br.readLine().split(" ");

				m = Integer.parseInt(args[0]);
				n = Integer.parseInt(args[1]);

				start = Math.min(m, n);
				end = Math.max(m, n);

				char[] array = line.substring(start, end+1).toCharArray();
				char c = array[0];
				boolean equals = true;
				for (char x : array) {
					if (c != x) {
						equals = false;
						break;
					}
				}
				System.out.println(equals ? "Yes" : "No");
				
			}
		}
	}

}
