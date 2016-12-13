import java.util.*;
import java.io.*;

/**
*	11463 - Commandos
*
*
*	Submision:	16899635
*	Date:		2016-02-24 18:13:02
*	Runtime:	0.326
*	Ranking:	1668
*/
public class Main11463 {

	
	static final int INF = (int) 1e9;

	/**
	 * - Floyd Warshall
	 * 
	 * El algoritmo
	 * consiste en hallar las distancias mínimas entre dos nodos siendo así, una
	 * generalización del Dijkstra
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 1
		// 5
		// 4
		// 0 1
		// 1 2
		// 1 4
		// 0 3

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(in.readLine());
			int[][] adj = new int[N][N];

			for (int i = 0; i < N; ++i) {
				Arrays.fill(adj[i], INF);
				adj[i][i] = 0;
			}

			int R = Integer.parseInt(in.readLine());
			for (int i = 0; i < R; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]);
				int v = Integer.parseInt(parts[1]);

				adj[u][v] = adj[v][u] = 1;
			}

			String[] parts = in.readLine().split("[ ]+");
			int s = Integer.parseInt(parts[0]);
			int e = Integer.parseInt(parts[1]);

			for (int k = 0; k < N; ++k)
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j) {
						// System.out.println("analizando adj["+i+"]["+j+"]= "+(adj[i][k]
						// + adj[k][j]));
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}

			int ans = 0;
			for (int i = 0; i < N; ++i)
				ans = Math.max(ans, adj[s][i] + adj[i][e]);
			System.out.println("Case " + t + ": " + ans);
		}

		in.close();
		System.exit(0);
	}
}