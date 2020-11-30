import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10361 - Automatic Poetry
*
*	Submission:	25763388
*	Date:		2020-11-25 15:21:25
*	Runtime:	0.050
*	Ranking:	4791 / 5028
*/
public class Main10361 {

	/**
	 * - Cadena de caracteres
	 *
	 * Reemplazar el texto de una cadena en otra
	 */	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder output = new StringBuilder();
		int testCases = Integer.parseInt(br.readLine());

		int x1, x2, y1, y2;

		char l1[];
		String l2;

		while (testCases-- > 0) {
			l1 = br.readLine().toCharArray();
			l2 = br.readLine();

			x1 = x2 = y1 = y2 = -1;

			for (int i = 0; i < l1.length; i++) {
				if (l1[i] == '<') {
					if (x1 == -1) {
						x1 = i;
					} else {
						y1 = i;
					}
				} else if (l1[i] == '>') {
					if (x2 == -1) {
						x2 = i;
					} else {
						y2 = i;
					}
				}
			}

			String s2 = (String.copyValueOf(l1).subSequence(x1, x2 + 1)).toString();
			String s3 = (String.copyValueOf(l1).subSequence(x2 + 1, y1)).toString();
			String s4 = (String.copyValueOf(l1).subSequence(y1, y2 + 1)).toString();
			String s5 = (String.copyValueOf(l1).subSequence(y2 + 1, l1.length)).toString();

			output.append(String.copyValueOf(l1).replaceAll("[<|>]", "") + "\n");

			output.append(l2.replace("...", s4.concat(s3).concat(s2).concat(s5).replaceAll("[<|>]", "") + "\n"));

		}

		System.out.print(output);

	}

}
