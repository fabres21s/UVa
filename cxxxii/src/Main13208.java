import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13208 - Drought in Nlogonia
*
*
*	Submision:	19822174
*	Date:		2017-08-08 17:09:13
*	Runtime:	0.950
*	Ranking:	27
*/
public class Main13208 {

	/*
	 * - Fórmulas matemáticas
	 * 
	 * Dadas las dimensiones de una serie de tanques que están unidos,
	 * encontrar el máximo volumen de agua que pueden almacenar
	 * 
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		int bottom, segments;
		while (testCases-- > 0) {
			args = br.readLine().split(" ");
			bottom = Integer.parseInt(args[0]);
			segments = Integer.parseInt(args[1]) + 1;

			long distances[] = new long[segments];
			long heights[] = new long[segments + 1];

			args = br.readLine().split(" ");
			int index = 0;
			for (String s : args) {
				distances[index] = Integer.parseInt(s);
				index++;
			}

			index = 0;
			args = br.readLine().split(" ");
			for (String s : args) {
				heights[index] = Integer.parseInt(s);
				index++;
			}

			long a = heights[0];
			long b, d = distances[0];
			long volume = 0;
			for (index = 1; index < segments; index++) {
				b = heights[index];

				if (a < b || a == b) {
					volume += a * d * bottom;
					a = b;
					d = distances[index];
				} else {
					// buscar mayor
					long mayor = 0;
					int posMayor = 0;
					d = 0;
					for (int i = index; i < segments; i++) {
						if (heights[i] > mayor) {

							mayor = heights[i];
							posMayor = i;

							if (mayor > a) {
								break;
							}
						}
					}

					if (posMayor > 0) {
						for (int i = index - 1; i < posMayor; i++) {
							d += distances[i];
						}
						a = Math.min(heights[posMayor], a);
						b = heights[posMayor + 1];
						index = posMayor;
						volume += a * d * bottom;
						a = heights[posMayor];
						d = distances[posMayor];
					}
				}
			}
			System.out.println(volume);
		}
	}

}
