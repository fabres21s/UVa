import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
*	1644 - Prime Gap
*
*	Submision:	21640713
*	Date:		2018-07-20 19:57:38
*	Runtime:	0.090
*	Ranking:	579 / 774
*/
public class Main1644 {
	
	static List<Integer> memoria = new ArrayList<Integer>();

	/**
	 * - Números primos
	 * 
	 * Dado un número, encontrar la diferencia entre los primos más cercanos a ese número
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		memoria.add(2);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int n, n1 = 0, n2 = 0;
		while ((n = (Integer.parseInt(br.readLine()))) != 0) {

			if (esprimo(n)) {
				n1 = n2 = n;
			} else {
				if (n % 2 == 0) {
					n--;

				}
				n1 = n;
				n2 = n + 2;
				while (!esprimo(n1)) {
					n1 -= 2;
				}
				while (!esprimo(n2)) {
					n2 += 2;
				}

			}
			output.append((n2 - n1));
			output.append("\n");
		}
		System.out.print(output);

	}

	static boolean esprimo(int n) {

		if (memoria.contains(n)) {
			return true;
		}
		int i;
		if ((n % 2) == 0) {
			return false;
		}
		i = 3;
		while (i <= Math.sqrt(n) + 1) {
			if ((n % i) == 0) {
				return false;
			}
			i += 2;
		}
		memoria.add(n);

		return true;
	}

}
