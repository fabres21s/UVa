import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10018 - Reverse and Add
*
*
*	Submision:	9159282
*	Date:		2011-08-16 20:29:27
*	Runtime:	1.000
*	Ranking:	17372
*/
public class Main10018 {

	/**
	 * - Cadena de caracteres
	 * - Proceso matemático
	 * 
	 * Tomar un número, preguntar si el inverso es igual, si no lo es sumarlo
	 */
	public static void main(String[] args) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int n = Integer.valueOf(reader.readLine());

		for (int i = 0; i < n; i++) {
			int cont = 0;
			long valor = Long.valueOf(reader.readLine());
			while (reverse(valor) != valor) {
				valor += reverse(valor);
				cont++;

				// System.out.println(valor);
			}
			System.out.println(cont + " " + valor);
		}
	}

	public static long reverse(long num) {
		long dig = 0, rev = 0;
		while (num > 0) {
			dig = num % 10;
			rev = rev * 10 + dig;
			num = num / 10;
		}
		return rev;
	}

}
