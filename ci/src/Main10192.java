import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10192 - Vacation
*
*	Submission:	25763366
*	Date:		2020-11-25 15:17:19
*	Runtime:	0.140
*	Ranking:	6820 / 7124
*/
public class Main10192 {

	/**
	 * - Cadena de caracteres
	 * - Secuencias
	 *
	 * Dadas 2 cadenas, encontrar la máxima subsecuencia entre ellos
	 */	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder output = new StringBuilder();
		String suggestion1, suggestion2;
		int testCases = 0, lcs = 0;

		while (!(suggestion1 = br.readLine()).equals("#")) {
			suggestion2 = br.readLine();

			testCases++;

			lcs = hallarMaximaSecuencia(suggestion1.toCharArray(), suggestion2.toCharArray());

			output.append(String.format("Case #%d: you can visit at most %d cities.\n", testCases, lcs));

		}

		System.out.print(output);
	}

	public static int hallarMaximaSecuencia(char[] a, char[] b) throws IOException {

		int LCS[][] = new int[1005][1005];

		for (int i = 1; i <= a.length; i++) {
			for (int j = 1; j <= b.length; j++) {
				if (a[i - 1] == b[j - 1])
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = (LCS[i - 1][j] > LCS[i][j - 1]) ? LCS[i - 1][j] : LCS[i][j - 1];
			}

		}
		return LCS[a.length][b.length];
	}

}
