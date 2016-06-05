import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10188 - Automated Judge Script
*
*
*	Submision:	9278084
*	Date:		2011-09-19 18:51:40
*	Runtime:	0.380
*	Ranking:	2443
*/
public class Main10188 {
	/**
	 * - Simulación
	 */
	public static void main(String[] args) throws IOException {
		int casos = 0;
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String linea;
		int i, m, n;
		while (!(linea = reader.readLine().trim()).equals("0")) {
			casos++;
			n = Integer.valueOf(linea);
			String correcto = "";
			for (i = 0; i < n; i++) {
				correcto += reader.readLine() + "\n";
			}
			m = Integer.valueOf(reader.readLine());
			String propuesto = "";
			for (i = 0; i < m; i++) {
				propuesto += reader.readLine() + "\n";
			}

			if (correcto.equals(propuesto)) {
				System.out.println("Run #" + casos + ": Accepted");
			} else {

				if (errorpresentacion(correcto, propuesto)) {
					System.out
							.println("Run #" + casos + ": Presentation Error");
				} else {
					System.out.println("Run #" + casos + ": Wrong Answer");
				}
			}
		}
	}

	static boolean errorpresentacion(String correcto, String propuesto) {
		String numeros = "1234567890";
		String n1 = "", n2 = "";
		String[] tokens = correcto.split("");
		for (int i = 1; i < tokens.length; i++) {
			if (numeros.contains(tokens[i])) {
				n1 += tokens[i];
			}
		}
		tokens = propuesto.split("");
		for (int i = 1; i < tokens.length; i++) {
			if (numeros.contains(tokens[i])) {
				n2 += tokens[i];
			}
		}
		if (n2.equals(n1)) {
			return true;
		}
		return false;
	}
}
