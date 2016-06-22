import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main111 {

	/*
	 * TODO - Ponerle categoria y llevarlo al workspace
	 * No lo entiendo!!!
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

	private static int lcs(char[] s1, char[] s2) {

		int LCS[][] = new int[250][250];
		int s1_length = s1.length;
		int s2_length = s2.length;
		int i, j;
		for (i = 1; i <= s1_length; i++)
			for (j = 1; j <= s2_length; j++)
				if (s1[i - 1] == s2[j - 1])
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = (LCS[i - 1][j] > LCS[i][j - 1]) ? LCS[i - 1][j] : LCS[i][j - 1];
		return LCS[s1_length][s2_length];
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
