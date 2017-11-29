import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
*	11988 - Broken Keyboard (a.k.a. Beiju Text)
*
*
*	Submision:	20418866
*	Date:		2017-11-29 18:04:03
*	Runtime:	0.400
*	Ranking:	4077
*/
public class Main11988 {

	/**
	 * - Cadena de caracteres
	 * 
	 *  Todo el texto que esté entre [] ponerlo l principio de la cadena.
	 *  Poniendo primero lo que esté más al "fondo" teniendo en cuenta
	 *  que se puede dar [*[*] [*] *[*]]
	 */
	public static void main(String[] args) throws IOException {
		String text = "This_is_a_[Beiju]_text";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean home;

		StringBuffer current, output = new StringBuffer();
		LinkedList<StringBuffer> list;

		char[] array;
		while ((text = br.readLine()) != null) {
			home = false;
			current = new StringBuffer();
			list = new LinkedList<StringBuffer>();

			array = text.toCharArray();

			for (char c : array) {
				if (c == '[') {
					if (home) {
						list.addFirst(current);
					} else {
						list.addLast(current);
					}

					current = new StringBuffer();
					home = true;
				} else if (c == ']') {

					if (home) {
						list.addFirst(current);
					} else {
						list.addLast(current);
					}
					home = false;
					current = new StringBuffer();
				} else {
					current.append(c);
				}
			}

			if (home) {
				list.addFirst(current);
			} else {
				list.addLast(current);
			}
			for (StringBuffer answer : list) {
				output.append(answer);
			}
			output.append("\n");
		}
		System.out.print(output);

	}

}
