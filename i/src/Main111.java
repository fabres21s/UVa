import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
*	111 - History Grading
*
*
*	Submision:	17559377
*	Date:		2016-06-22 15:41:25
*	Runtime:	0.090
*	Ranking:	7647
*/
public class Main111 {

	/*
	 * - Arreglos
	 * 
	 * Encontrar la calificación de un estudiante dado un orden cronológico de sucesos
	 * y la respuesta que da el estudiante.
	 * Un poco enredado
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

			int n = Integer.parseInt(br.readLine());

			stk = new StringTokenizer(br.readLine());
			int correct []= new int[n]; 
			for (int i = 0; i < n; i++) {
				correct[i] = Integer.parseInt(stk.nextToken()) - 1;
			}

			String line;
			while ((line = br.readLine()) != null) {
				stk = new StringTokenizer(line);
				int proposed []  = new int[n];
				for (int j = 0; j < n; j++) {
					proposed[Integer.parseInt(stk.nextToken()) - 1] = j;
				}
				System.out.println(lis(proposed, correct));
			}
			br.close();
			System.exit(0);

	}

	//probar este método de sfmunera con enteros, proque no tengo ni idea
	static int lis(int[] s, int[] rank) {
		int N = s.length;
		int[] dp = new int[N];
		
		int ans = 0;
		for (int i = 0; i < N; ++i) {
			int max = 0;
			for (int j = 0; j < i; ++j)
				if (rank[s[i]] > rank[s[j]])
					max = Math.max(max, dp[j]);
			dp[i] = 1 + max;
			ans = Math.max(ans, dp[i]);
		}
		
		return ans;
	}

}