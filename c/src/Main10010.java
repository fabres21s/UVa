import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
*	10010 - Where's Waldorf?
*
*
*	Submission:	9267358
*	Date:		2011-09-16 19:27:04
*	Runtime:	1.508
*	Ranking:	6524
*/
public class Main10010 {
	/**
	 * - Arreglos
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String palabra;
		StringTokenizer data;
		int stPrimerov = Integer.parseInt(br.readLine());
		int m, n, k, i, j;
		for (i = 0; i < stPrimerov; i++) {
			br.readLine();
			data = new StringTokenizer(br.readLine());
			m = Integer.parseInt(data.nextToken());
			n = Integer.parseInt(data.nextToken());
			String[][] tablero = new String[m][n];
			for (j = 0; j < m; j++) {
				String[] tokens = br.readLine().toLowerCase().split("");
				for (int p = 0; p < n; p++) {
					tablero[j][p] = tokens[p + 1];
				}
			}
			k = Integer.parseInt(br.readLine());
			for (j = 0; j < k; j++) {

				palabra = br.readLine().toLowerCase();
				buscar(tablero, palabra);
			}
			if (i != stPrimerov - 1) {
				System.out.println("");
			}
		}

	}

	static void buscar(String[][] tablero, String palabra) {
		int i, j, aux, aux1;
		String letra = String.valueOf(palabra.charAt(0));
		for (i = 0; i < tablero.length; i++) {
			for (j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j].equals(letra)) {
					if ((i + palabra.length()) <= tablero.length)// busco hacia
																	// abajo
					{
						aux = i;
						while (letra.length() < palabra.length()) {
							aux++;
							letra += tablero[aux][j];
						}
						if (letra.equals(palabra)) {
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					letra = String.valueOf(palabra.charAt(0));
					if ((i + 1 - palabra.length()) >= 0)// busco hacia arriba
					{
						aux = i;
						while (letra.length() < palabra.length()) {
							aux--;
							letra += tablero[aux][j];
						}
						if (letra.equals(palabra)) {
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					letra = String.valueOf(palabra.charAt(0));
					if ((j + palabra.length()) <= tablero[0].length)// busco
																	// hacia la
																	// derecha
					{
						aux = j;
						while (letra.length() < palabra.length()) {
							aux++;
							letra += tablero[i][aux];
						}
						if (letra.equals(palabra)) {
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					letra = String.valueOf(palabra.charAt(0));
					if ((j + 1 - palabra.length()) >= 0)// busco hacia la
														// izquierda
					{
						aux = j;
						while (letra.length() < palabra.length()) {
							aux--;
							letra += tablero[i][aux];
						}
						if (letra.equals(palabra)) {
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					letra = String.valueOf(palabra.charAt(0));
					if ((i + palabra.length()) <= tablero.length
							&& (j + palabra.length()) <= tablero[0].length)// busco
																			// hacia
																			// abajo
																			// la
																			// derecha
					{
						aux = i + 1;
						aux1 = j + 1;
						while (letra.length() < palabra.length()) {
							letra += tablero[aux][aux1];
							aux++;
							aux1++;
						}
						if (letra.equals(palabra)) {
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					letra = String.valueOf(palabra.charAt(0));
					if ((i + palabra.length()) <= tablero.length
							&& (j + 1 - palabra.length()) >= 0)// busco hacia
																// abajo la
																// izquierda
					{
						aux = i + 1;
						aux1 = j - 1;
						while (letra.length() < palabra.length()) {
							letra += tablero[aux][aux1];
							aux++;
							aux1--;
						}
						if (letra.equals(palabra)) {
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					letra = String.valueOf(palabra.charAt(0));
					if ((i + 1 - palabra.length()) >= 0
							&& (j + 1 - palabra.length()) >= 0)// busco hacia
																// arriba la
																// izquierda
					{
						aux = i - 1;
						aux1 = j - 1;
						while (letra.length() < palabra.length()) {
							letra += tablero[aux][aux1];
							aux--;
							aux1--;
						}
						if (letra.equals(palabra)) {
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					letra = String.valueOf(palabra.charAt(0));
					if ((i + 1 - palabra.length()) >= 0
							&& (j + palabra.length()) <= tablero[0].length)// busco
																			// hacia
																			// arriba
																			// la
																			// derecha
					{
						aux = i - 1;
						aux1 = j + 1;
						while (letra.length() < palabra.length()) {
							letra += tablero[aux][aux1];
							aux--;
							aux1++;
						}
						if (letra.equals(palabra)) {
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					letra = String.valueOf(palabra.charAt(0));
				}
			}
		}
	}
}
