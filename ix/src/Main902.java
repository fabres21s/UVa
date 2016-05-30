import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 902 - Password Search Cadena de caracteres Dado n y una cadena, encontrar el
 * substring de tamaño n que más veces se repite
 * 
 * @author fabio
 *
 *
 */

/**
*	902 - Password Search
*
*
*	Submision:	17018481
*	Date:		2016-03-15 01:44:40
*	Runtime:	0.562
*	Ranking:	160
*/
public class Main902 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n, maxRepeat, repeat;
		String message, subString, maxSubString;
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (input.hasNext()) {

			n = input.nextInt();
			message = input.next();

			maxSubString = "";
			maxRepeat = 0;

			for (int i = 0; i < message.length() - n + 1; i++) {
				subString = message.substring(i, i + n);
				if (!map.containsKey(subString)) {
					map.put(subString, 0);
				}

				repeat = map.get(subString) + 1;

				if (repeat > maxRepeat) {
					maxRepeat = repeat;
					maxSubString = subString;
				}
				map.put(subString, repeat);
			}
			System.out.println(maxSubString);
			map.clear();

		}
	}

}
