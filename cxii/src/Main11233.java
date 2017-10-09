import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
*	11233 - Deli Deli
*
*	Submision:	20141019
*	Date:		2017-10-09 01:09:48
*	Runtime:	0.040
*	Ranking:	2271
*/
public class Main11233 {

	static Map<String, String> dictionaryIrregularWords = new HashMap<String, String>();

	/**
	 * - Map
	 * - Validaciones
	 * 
	 *  Dados un diccionario con las palabras y su forma plural,
	 *  y una lista de palabras, hallar el plural de cada una de ellas
	 *  siguiendo las reglas en inglés 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuffer output = new StringBuffer();
		String word;

		args = br.readLine().split(" ");
		int irregularsWords = Integer.parseInt(args[0]), otherWords = Integer.parseInt(args[1]);

		for (int i = 0; i < irregularsWords; i++) {
			args = br.readLine().split(" ");
			dictionaryIrregularWords.put(args[0], args[1]);
		}

		for (int i = 0; i < otherWords; i++) {
			word = br.readLine();
			output.append(getPluralForm(word));
			output.append("\n");
		}

		System.out.print(output);

	}

	private static String getPluralForm(String word) {
		String result = dictionaryIrregularWords.get(word);

		if (result == null) {
			if (word.endsWith("y")) {
				String lastTwo = word.substring(word.length() - 2, word.length());
				if (!lastTwo.contains("a") && !lastTwo.contains("e") && !lastTwo.contains("i") && !lastTwo.contains("o")
						&& !lastTwo.contains("u")) {
					StringBuffer aux = new StringBuffer(word);
					aux.reverse();
					result = aux.replace(0, 1, "i").reverse().toString() + "es";

				} else {
					result = word + "s";
				}
			} else if (word.endsWith("sh") || word.endsWith("ch") || word.endsWith("o") || word.endsWith("s")
					|| word.endsWith("x")) {
				result = word + "es";
			} else {
				result = word + "s";
			}
		}
		return result;
	}
}
