import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	10420 - List of Conquests
*
*
*	Submision:	12030067
*	Date:		2013-07-10 15:33:56
*	Runtime:	0.512
*	Ranking:	8266
*/
public class Main10420 {

	/**
	 * - Map
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> list = new ArrayList<String>();
		String pais;
		for (int i = 0; i < k; i++) {
			pais = input.next();
			if (map.get(pais) == null) {
				map.put(pais, 1);
				list.add(pais);
			} else {

				map.put(pais, map.get(pais) + 1);
			}
			input.nextLine();

		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + " " + map.get(list.get(i)));
		}
		input.close();

	}

}
