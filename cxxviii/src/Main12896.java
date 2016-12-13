import java.util.Scanner;

/**
*	12896 - Mobile SMS
*
*
*	Submision:	17423851
*	Date:		2016-05-26 23:35:41
*	Runtime:	0.130
*	Ranking:	637
*/

public class Main12896 {

	/**
	 * - Arreglos
	 * 
	 * Dado un teclado de celular, de los antiguos, el número que
	 * se presionó y la cantidad de veces que hizo, encontrar el mensaje que fue
	 * escrito
	 */
	public static void main(String[] args) {
		String arrayLetras[][] = { { "", " " }, { "", ".", ",", "?", "\"" },
				{ "", "a", "b", "c", "\"" }, { "", "d", "e", "f", "\"" },
				{ "", "g", "h", "i", "\"" }, { "", "j", "k", "l", "\"" },
				{ "", "m", "n", "o", "\"" }, { "", "p", "q", "r", "s" },
				{ "", "t", "u", "v", "\"" }, { "", "w", "x", "y", "z" }, };

		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		int letras;

		for (int i = 0; i < testCases; i++) {
			letras = input.nextInt();

			int arrayNumeros[][] = new int[2][letras];

			for (int x = 0; x < 2; x++) {
				for (int y = 0; y < letras; y++) {
					arrayNumeros[x][y] = input.nextInt();
				}
			}

			StringBuffer output = new StringBuffer();

			for (int x = 0; x < letras; x++) {
				output.append(arrayLetras[arrayNumeros[0][x]][arrayNumeros[1][x]]);
			}
			System.out.println(output);
		}
		input.close();
	}

}
