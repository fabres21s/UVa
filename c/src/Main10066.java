import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10066 - The Twin Towers
*
*
*	Submission:	19669471
*	Date:		2017-07-15 20:02:43
*	Runtime:	0.040
*	Ranking:	6939 / 7416
*/
public class Main10066 {

	/**
	 * - Secuencias
	 *
	 * Dadas 2 estructuras (arreglos) encontrar la máxima subsecuencia entre ellos
	 * similar al 10405
	 */	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1, n2;
		int testCases = 0;
		StringBuffer output = new StringBuffer();
		while (true) {
			args = br.readLine().split(" ");
			n1 = Integer.parseInt(args[0]);
			n2 = Integer.parseInt(args[1]);
			
			if (n1 == n2 && n2 == 0) {
				break;
			}
			
			
			args = br.readLine().split(" ");
			int s1 []= new int[n1];
			int s2 []= new int[n2];
			
			for (int i = 0; i < args.length; i++) {
				s1[i] = Integer.parseInt(args[i]);
			}
			
			args = br.readLine().split(" ");
			for (int i = 0; i < args.length; i++) {
				s2[i] = Integer.parseInt(args[i]);
			}
			int i,j;
			int [][] LCS = new int[111][111];
			for (i = 1; i <= n1; i++)
				for (j = 1; j <= n2; j++)
					if (s1[i - 1] == s2[j - 1])
						LCS[i][j] = LCS[i - 1][j - 1] + 1;
					else
						LCS[i][j] = (LCS[i - 1][j] > LCS[i][j - 1]) ? LCS[i - 1][j]
								: LCS[i][j - 1];
						
			testCases++;
			output.append("Twin Towers #"+testCases);
			output.append("\nNumber of Tiles : "+LCS[n1][n2]);
			output.append("\n\n");
		}
		
		System.out.print(output);
	}

}
