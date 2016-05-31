import java.util.Arrays;
import java.util.Scanner;

/**
*	12250 - Language Detection
*
*
*	Submision:	9573641
*	Date:		2011-12-19 02:45:19
*	Runtime:	0.404
*	Ranking:	5738
*/
public class Main12250 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String[] languages = { "FRENCH", "ITALIAN", "GERMAN", "ENGLISH",
				"SPANISH", "RUSSIAN" };
		final String[] saludos = { "BONJOUR", "CIAO", "HALLO", "HELLO", "HOLA",
				"ZDRAVSTVUJTE" };
		Scanner input = new Scanner(System.in);
		int busq, i = 1;
		String p;
		while (input.hasNext()) {
			p = input.next();
			if (p.equals("#")) {
				break;
			}
			busq = Arrays.binarySearch(saludos, p);
			if (busq > -1) {
				System.out.println("Case " + i + ": " + languages[busq]);
			} else {
				System.out.println("Case " + i + ": UNKNOWN");
			}
			i++;
		}
		// TODO Auto-generated method stub
	}
}
