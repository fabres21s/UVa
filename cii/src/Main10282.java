import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	10282 - Babelfish
*
*
*	Submission:	16423775
*	Date:		2015-11-11 14:33:47
*	Runtime:	1.429
*	Ranking:	3656
*/
public class Main10282 {

	/**
	 * - Map
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String line = "";
		Map<String, String> map = new HashMap<String, String>();
		String r = "";
		boolean answer = false;
		while (input.hasNext()) {

			line = input.nextLine();

			if (answer) {
				r = map.get(line);
				System.out.println((r == null) ? "eh" : r);
			} else {

				answer = (line.isEmpty());

				if (!answer) {

					args = line.split(" ");
					map.put(args[1], args[0]);
				}

			}

		}
		input.close();
	}

}
