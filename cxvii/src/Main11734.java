import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11734 - Big Number of Teams will Solve This
*
*
*	Submission:	16775496
*	Date:		2016-01-29 16:30:19
*	Runtime:	0.056
*	Ranking:	2243
*/
public class Main11734 {

	/**
	 * - Reemplazo de caracteres
	 * 
	 * Comparar una respuesta correcta, con una propuesta
	 * si son iguales, YES si difieren en espacios OFE si no WA
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// bufferedreader
		int cases = 0;
		cases = Integer.valueOf(br.readLine());

		String correct, proposed, answer;
		for (int i = 1; i <= cases; i++) {

			try {
				correct = br.readLine();
				proposed = br.readLine();

				if (correct.equals(proposed)) {
					answer = "Yes";
				} else if (correct.replaceAll(" ", "").equals(proposed)) {
					answer = "Output Format Error";
				} else {
					answer = "Wrong Answer";
				}
			} catch (Exception exc) {
				answer = "Wrong Answer";// NO ENTIENDO!!1 Qu� estaba generando
										// el RE??? - creo era el package uva
			}

			System.out.printf("Case %d: %s\n", i, answer);
		}

	}

}
