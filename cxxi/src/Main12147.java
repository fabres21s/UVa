import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
*	12147 - DNA Sequences
*
*
*	Submision:	19844559
*	Date:		2017-08-12 19:33:24
*	Runtime:	0.530
*	Ranking:	67
*/
public class Main12147 {

	/**
	 * - Secuencias
	 * 
	 * Encontrar la máxima secuencia entre dos palabras
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k;
		StringBuffer output = new StringBuffer();
		while ((k = Integer.parseInt(br.readLine())) != 0) {
			output.append(lcs(br.readLine(), br.readLine(), k) + "\n");
		}
		System.out.print(output);
	}

	public static int lcs(String s1, String s2, int k) {
		s1 = "#" + s1;
		s2 = "#" + s2;
		int C[][] = new int[s1.length()][s2.length()];
		for (int a = k; a < s1.length(); a++) {
			for (int b = k; b < s2.length(); b++) {
				C[a][b] = Math.max(C[a][b - 1], C[a - 1][b]);
				for (int c = 0; c <= a; c++) {// or c <=b
					if (c >= k) {
						C[a][b] = Math.max(C[a][b], C[a - c][b - c] + c);
					}
					if (s1.charAt(a - c) != s2.charAt(b - c))
						break;
				}
			}
		}
		return C[s1.length() - 1][s2.length() - 1];
	}
}
