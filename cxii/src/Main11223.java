import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	11223 - O: dah dah dah!
*
*
*	Submision:	12326278
*	Date:		2013-09-10 17:32:38
*	Runtime:	0.258
*	Ranking:	1523
*/
public class Main11223 {

	/**
	 * - Map
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(".-", "A");
		map.put("-...", "B");
		map.put("-.-.", "C");
		map.put("-..", "D");
		map.put(".", "E");
		map.put("..-.", "F");
		map.put("--.", "G");
		map.put("....", "H");
		map.put("..", "I");
		map.put(".---", "J");
		map.put("-.-", "K");
		map.put(".-..", "L");
		map.put("--", "M");
		map.put("-.", "N");
		map.put("---", "O");
		map.put(".--.", "P");
		map.put("--.-", "Q");
		map.put(".-.", "R");
		map.put("...", "S");
		map.put("-", "T");
		map.put("..-", "U");
		map.put("...-", "V");
		map.put(".--", "W");
		map.put("-..-", "X");
		map.put("-.--", "Y");
		map.put("--..", "Z");
		map.put("-----", "0");
		map.put(".----", "1");
		map.put("..---", "2");
		map.put("...--", "3");
		map.put("....-", "4");
		map.put(".....", "5");
		map.put("-....", "6");
		map.put("--...", "7");
		map.put("---..", "8");
		map.put("----.", "9");
		map.put(".-.-.-", ".");
		map.put("--..--", ",");
		map.put("..--..", "?");
		map.put(".----.", "'");
		map.put("-.-.--", "!");
		map.put("-..-.", "/");
		map.put("-.--.", "(");
		map.put("-.--.-", ")");
		map.put(".-...", "&");
		map.put("---...", ":");
		map.put("-.-.-.", ";");
		map.put("-...-", "=");
		map.put(".-.-.", "+");
		map.put("-....-", "-");
		map.put("..--.-", "_");
		map.put(".--.-.", "@");
		map.put(".-..-.", "\"");
		// map.put("  ", " ");

		Scanner texto = new Scanner(System.in);
		Scanner input = new Scanner(texto.nextLine());
		int k = input.nextInt();
		// String message;
		String arreglo[];
		boolean first = true;
		StringBuffer buffer;

		for (int i = 1; i <= k; i++) {
			String linea[] = texto.nextLine().split("  ");
			// cicloInfinito();
			if (!first) {

				System.out.println();
			}
			System.out.println("Message #" + i);
			buffer = new StringBuffer();
			for (String string : linea) {
				arreglo = string.split(" ");
				for (String key : arreglo) {

					buffer.append(map.get(key));
				}
				buffer.append(" ");

			}
			System.out.println(buffer.toString().trim());
			first = false;
		}
		input.close();
		texto.close();

	}

	static void cicloInfinito() {
		int i = 1, x = 5;
		while (i < x) {
			i /= 1;
		}
	}

}
