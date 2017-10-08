import java.util.Scanner;

/**
*	10405 - Longest Common Subsequence
*
*
*	Submision:	9705740
*	Date:		2012-02-03 15:58:17
*	Runtime:	0.288
*	Ranking:	8894
*/
public class Main10405 {
	static int LCS[][] = new int[1005][1005];

	/**
	 * - Secuencias
	 *
	 * Dadas 2 cadenas, encontrar la máxima subsecuencia entre ellos
	 */	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char s1[], s2[];
		while (input.hasNext()) {
			s1 = input.next().toCharArray();
			s2 = input.next().toCharArray();
			int s1_length = s1.length;
			int s2_length = s2.length;
			int i, j;
			for (i = 1; i <= s1_length; i++)
				
				for (j = 1; j <= s2_length; j++)
					if (s1[i - 1] == s2[j - 1])
						LCS[i][j] = LCS[i - 1][j - 1] + 1;
					else
						LCS[i][j] = (LCS[i - 1][j] > LCS[i][j - 1]) ? LCS[i - 1][j]
								: LCS[i][j - 1];
			System.out.printf("%d\n", LCS[s1_length][s2_length]);
		}
		input.close();
	}
}
