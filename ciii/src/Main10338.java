import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
*	10338 - Mischievous Children
*
*
*	Submission:	17168707
*	Date:		2016-04-08 18:34:06
*	Runtime:	0.840
*	Ranking:	4193 / 4898
*/
public class Main10338 {

	/**
	 * - Arreglos
	 * - Estad�stica
	 * - Big Numbers
	 * 
	 * Encontrar, en una palabra, la cantidad de posibles permutaciones
	 * que salen a partir de las letras de ella
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BigInteger[] factorials = new BigInteger[22];

		factorials[1] = factorials[0] = BigInteger.ONE;
		for (int i = 2; i < 22; i++) {

			factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCases; i++) {
			char[] word = br.readLine().toCharArray();

			int arreglo[] = new int[30];
			for (char mander : word) {
				arreglo[mander - 65]++;
			}
			BigInteger numerador = factorials[word.length];
			BigInteger denominador = BigInteger.ONE;

			for (int x = 0; x < 30; x++) {
				if (arreglo[x] > 1) {
					denominador = denominador.multiply(factorials[arreglo[x]]);
				}
			}

			System.out.println("Data set " + i + ": "
					+ numerador.divide(denominador));

		}

	}

}
