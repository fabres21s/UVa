import java.util.Arrays;
import java.util.Scanner;

/**
*	1025 - 	A Spy in the Metro
*
*
*	Submision:	25159949
*	Date:		2020-06-20 23:59:45
*	Runtime:	0.180
*	Ranking:	993 / 1022
*/
public class Main1025 {

	static int dp[][] = new int[250][51];

	static int start[] = new int[51];
	static int fin[] = new int[51];

	static boolean hasright[][] = new boolean[1000][51];
	static boolean hasleft[][] = new boolean[1000][51];

	static int trans1[] = new int[51];
	static int trans2[] = new int[51];

	static int INF = 9999999;

	/**
	 * - Programación dinámica
	 * 
	 * Sacado de https://github.com/Kevinwen1999/UVa-solutions/blob/master/1025%20-%20A%20Spy%20in%20the%20Metro.cpp
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int cnt = 1;
		int N, T, M1, M2;

		while (true) {

			init();

			N = input.nextInt();
			if (N == 0)
				break;
			T = input.nextInt();
			for (int i = 0, temp; i < N - 1; i++) {
				temp = input.nextInt();
				trans1[i] = trans2[i + 1] = temp;
			}
			M1 = input.nextInt();
			for (int i = 0; i < M1; i++)
				start[i] = input.nextInt();
			M2 = input.nextInt();
			for (int i = 0; i < M2; i++)
				fin[i] = input.nextInt();

			int curtime;
			for (int i = 0; i < M1; i++) {
				curtime = start[i];
				hasright[curtime][0] = true;
				for (int j = 0; j < N - 1; j++) {
					curtime += trans1[j];

					try {
						hasright[curtime][j + 1] = true;
					} catch (Exception e) {
						System.out.println("error " + curtime + " " + (j + 1));
					}
				}
			}
			for (int i = 0; i < M2; i++) {
				curtime = fin[i];
				hasleft[curtime][N - 1] = true;
				for (int j = N - 1; j > 0; j--) {
					curtime += trans2[j];
					hasleft[curtime][j - 1] = true;
				}
			}

			System.out.printf("Case Number %d: ", cnt);
			int ans = mintime(0, 0, T, N);
			if (ans == INF)
				System.out.println("impossible");
			else
				System.out.println(ans);
			cnt++;
		}

	}

	private static void init() {
		start = new int[51];
		fin = new int[51];

		hasright = new boolean[1000][51];
		hasleft = new boolean[1000][51];

		trans1 = new int[51];
		trans2 = new int[51];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}

	}

	static int mintime(int timeused, int station, int T, int N) {

		if (timeused > T)
			return INF;
		if (station == N - 1 && timeused == T)
			return 0;
		if (dp[timeused][station] != -1)
			return dp[timeused][station];
		int ans = INF;
		if (hasright[timeused][station] && station != N - 1)
			ans = Math.min(ans, mintime(timeused + trans1[station], station + 1, T, N));
		if (hasleft[timeused][station] && station != 0)
			ans = Math.min(ans, mintime(timeused + trans2[station], station - 1, T, N));
		ans = Math.min(ans, mintime(timeused + 1, station, T, N) + 1);

		return dp[timeused][station] = ans;
	}

}
