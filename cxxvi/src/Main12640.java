import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	12640 - Largest Sum Game
*
*
*	Submision:	12353608
*	Date:		2013-09-16 14:40:17
*	Runtime:	0.686
*	Ranking:	464
*/
class Main12640 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader lect = new BufferedReader(new InputStreamReader(
				System.in));

		String linea = lect.readLine();

		while (true) {
			try {
				String temp[] = linea.split(" ");
				int size = temp.length;
				int[] numeros = new int[size];
				int suma = 0, mayor = 0;

				for (int i = 0; i < size; i++) {
					numeros[i] = Integer.parseInt(temp[i]);
					suma += numeros[i];
					if (suma > mayor) {
						mayor = suma;
					}
					if (suma < 0) {
						suma = 0;
					}
				}
				System.out.println(mayor);

				linea = lect.readLine();
			} catch (Exception e) {
				System.exit(0);
			}

		}
	}
}
