import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	11151 - Longest Palindrome
*
*	Submission:	21310377
*	Date:		2018-05-14 13:55:24
*	Runtime:	0.120
*	Ranking:	2297
*/
public class Main11151 {

	static int LCS[][] = new int[1005][1005];

	/**
	 * - Palíndromos
	 * - Secuencias
	 * 
	 * Dada una palabra, encontrar el más largo palíndromo en ella
	 * se solucionó dándole la vuelta a la palabra y encontrando el LCS
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		String word, wordReverse;
		StringBuffer output = new StringBuffer();

		char s1[], s2[];
		for (int x = 0; x < testCases; x++) {
			word = br.readLine();
			wordReverse = new StringBuffer(word).reverse().toString();

			s1 = word.toCharArray();
			s2 = wordReverse.toCharArray();

			int s1_length = s1.length;
			int s2_length = s2.length;
			int i, j;
			for (i = 1; i <= s1_length; i++)

				for (j = 1; j <= s2_length; j++)
					if (s1[i - 1] == s2[j - 1])
						LCS[i][j] = LCS[i - 1][j - 1] + 1;
					else
						LCS[i][j] = (LCS[i - 1][j] > LCS[i][j - 1]) ? LCS[i - 1][j] : LCS[i][j - 1];
			output.append(LCS[s1_length][s2_length]);
			output.append("\n");

		}
		System.out.print(output);
	}

}
