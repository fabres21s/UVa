import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10679 - I Love Strings!! Cadena de caracteres, Reemplazar, Arreglos En una
 * cadena de caracteres, ver si un string es substring de la cadena original
 * 
 * @author fabio
 *
 */

/**
*	10679 - I Love Strings!!
*
*
*	Submision:	16991525
*	Date:		2016-03-10 21:02:54
*	Runtime:	0.932
*	Ranking:	1301
*/
public class Main10679 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		int buscar;
		char[] line;
		StringBuffer output = new StringBuffer();
		while (testCases-- > 0) {
			line = br.readLine().toCharArray();
			buscar = Integer.parseInt(br.readLine());

			while (buscar-- > 0) {
				output.append(evaluate(br.readLine().toCharArray(), line));
			}

		}
		System.out.print(output);

	}

	private static String evaluate(char[] charArray, char[] line) {
		int index = 0;
		char buscar = charArray[index];
		boolean found = false;
		for (char c : line) {
			if (c == buscar) {

				index++;

				if (index == charArray.length) {
					found = true;
					break;
				}
			} else {
				index = 0;
			}
			buscar = charArray[index];
		}
		return (found ? "y" : "n") + "\n";
	}

}
