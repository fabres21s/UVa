import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	11530 - SMS Typing
*
*
*	Submission:	12366077
*	Date:		2013-09-19 00:46:11
*	Runtime:	0.198
*	Ranking:	5705
*/
public class Main11530 {

	/**
	 * - Map
	 */
	public static void main(String[] args) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		map.put('a', 1);
		map.put('d', 1);
		map.put('g', 1);
		map.put('j', 1);
		map.put('m', 1);
		map.put('p', 1);
		map.put('t', 1);
		map.put('w', 1);
		map.put(' ', 1);

		map.put('b', 2);
		map.put('e', 2);
		map.put('h', 2);
		map.put('k', 2);
		map.put('n', 2);
		map.put('q', 2);
		map.put('u', 2);
		map.put('x', 2);

		map.put('c', 3);
		map.put('f', 3);
		map.put('i', 3);
		map.put('l', 3);
		map.put('o', 3);
		map.put('r', 3);
		map.put('v', 3);
		map.put('y', 3);

		map.put('s', 4);
		map.put('z', 4);

		Scanner input = new Scanner(System.in);
		int k = input.nextInt() + 1;
		input.nextLine();
		for (int i = 1; i < k; i++) {
			char[] arreglo = input.nextLine().toCharArray();
			int typing = 0;
			for (char c : arreglo) {
				typing += map.get(c);
			}
			System.out.printf("Case #%d: %d\n", i, typing);
		}
		input.close();

	}

}
