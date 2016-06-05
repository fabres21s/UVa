import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	12626 - I ❤ Pizza
*
*
*	Submision:	12306426
*	Date:		2013-09-06 16:19:22
*	Runtime:	0.915
*	Ranking:	1711
*/
public class Main12626 {

	/**
	 * - Map
	 */
	public static void main(String[] args) {

		Map<String, Integer> map;
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		// char [] c;
		while (k-- > 0) {
			map = new HashMap<String, Integer>();
			map.put("M", 0);
			map.put("A", 0);
			map.put("R", 0);
			map.put("G", 0);
			map.put("I", 0);
			map.put("T", 0);

			args = input.next().split("");
			for (String c : args) {
				if (c.equals("M")) {
					map.put("M", map.get("M") + 1);
				} else if (c.equals("A")) {
					map.put("A", map.get("A") + 1);
				} else if (c.equals("R")) {
					map.put("R", map.get("R") + 1);
				} else if (c.equals("G")) {
					map.put("G", map.get("G") + 1);
				} else if (c.equals("T")) {
					map.put("T", map.get("T") + 1);
				} else if (c.equals("I")) {
					map.put("I", map.get("I") + 1);
				}
			}
			int menor = 600, div;

			div = map.get("M");
			if (div < menor) {
				menor = div;
			}

			div = map.get("A") / 3;
			if (div < menor) {
				menor = div;
			}

			div = map.get("R") / 2;
			if (div < menor) {
				menor = div;
			}

			div = map.get("G");
			if (div < menor) {
				menor = div;
			}

			div = map.get("I");
			if (div < menor) {
				menor = div;
			}

			div = map.get("T");
			if (div < menor) {
				menor = div;
			}

			System.out.println(menor);
		}
		input.close();

	}

}
