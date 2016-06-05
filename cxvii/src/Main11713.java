import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11713 - Abstract Names
*
*
*	Submision:	10220669
*	Date:		2012-06-13 15:23:36
*	Runtime:	0.168
*	Ranking:	3345
*/
public class Main11713 {

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		int n = Integer.parseInt(input.readLine()), j;
		char[] x, y;
		boolean diferente;
		for (int i = 0; i < n; i++) {
			x = input.readLine().trim().toCharArray();
			y = input.readLine().trim().toCharArray();
			if (x.length != y.length) {
				System.out.println("No");
				continue;
			}
			diferente = false;
			for (j = 0; j < x.length; j++) {
				if (!isVowel(x[j])) {
					if (x[j] != y[j]) {
						diferente = true;
						break;
					}
				}
			}
			if (diferente)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
	}

	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}
}
