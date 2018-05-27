import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11723 - Numbering Roads
*
*	Submission:	21319116
*	Date:		2018-05-16 10:31:04
*	Runtime:	0.170
*	Ranking:	4352
*/
public class Main11723 {

	/**
	 * - Ad hoc
	 * 
	 * Validar si se pueden utilizar las letras sin repetir en unas calles
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuffer output = new StringBuffer();
		int r, n, answer, cases = 0;
		while (!(line = br.readLine()).equals("0 0")) {
			args = line.split(" ");
			r = Integer.parseInt(args[0]) - 1;
			n = Integer.parseInt(args[1]);
			answer = r / n;

			output.append("Case " + (++cases));
			if (answer > 26) {
				output.append(": impossible");
			} else { 
				output.append(": " + answer);
			}
			output.append("\n");

		}
		System.out.print(output);
	}

}
