import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
*	10815 - Andy's First Dictionary
*
*
*	Submision:	16288000
*	Date:		2015-10-18 13:57:27
*	Runtime:	0.535
*	Ranking:	5225
*/
public class Main10815 {

	/**
	 * - Expresiones Regulares
	 * - SortedSet
	 */
	public static void main(String[] args) {
		String text = "fabio ausa 83979	wr.,><>!!3$6ndres Sierra jaraba 1992/03/31";

		Scanner input = new Scanner(System.in);

		StringBuffer entrada = new StringBuffer();
		while (input.hasNext()) {
			text = input.nextLine().toLowerCase();
			entrada.append(text + " ");

		}

		text = entrada.toString().replaceAll("[^a-zA-Z\\s]", " ");

		SortedSet<String> dictionary = new TreeSet<String>();
		input.close();

		input = new Scanner(text);
		while (input.hasNext()) {
			dictionary.add(input.next());
		}

		for (String palabra : dictionary) {
			System.out.println(palabra);
		}
		input.close();

	}

}
