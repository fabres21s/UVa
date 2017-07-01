import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13216 - Problem with a ridiculously long name but with a ridiculously short description
*
*
*	Submision:	19594911
*	Date:		2017-07-01 18:01:31
*	Runtime:	0.180
*	Ranking:	19
*/
public class Main13216 {

	/**
	 * - Pregenerado 
	 * - Modular
	 * - Potencias
	 *
	 * Hallar el valor de (66^n) mod 100
	 * Se usó como base el 1230 - MODEX
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		while (k > 0) {
			k--;
			System.out.println(evaluate(br.readLine()));
		}
	}

	private static String evaluate(String number) {
		if (number.equals("0")) {
			return "1";
		}
		if (number.equals("1")) {
			return "66";
		}
		
		if (number.endsWith("0")) {
			return "76";
		}
		
		if (number.endsWith("1")) {
			return "16";
		}
		if (number.endsWith("2")) {
			return "56";
		}
		if (number.endsWith("3")) {
			return "96";
		}
		if (number.endsWith("4")) {
			return "36";
		}
		if (number.endsWith("5")) {
			return "76";
		}
		if (number.endsWith("6")) {
			return "16";
		}
		if (number.endsWith("7")) {
			return "56";
		}
		if (number.endsWith("8")) {
			return "96";
		}
		if (number.endsWith("9")) {
			return "36";
		}
		return "";
	}

	
}
