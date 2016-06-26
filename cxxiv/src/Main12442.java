import java.util.Scanner;

/**
*	12442 - Forwarding Emails
*
*
*	Submision:	17531502
*	Date:		2016-06-16 22:24:00
*	Runtime:	0.910
*	Ranking:	996
*/
public class Main12442 {

	static int graph[];
	static boolean visited[];
	static int distances[];

	//TODO - Ponerle categor�a y llevarlo al workspace
	/*
	 * - Grafos
	 * - B�squeda en Profundidad
	 * 
	 * Encontrar el grafo origen con mayor cantidad de conexiones posibles
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int n = input.nextInt() + 1;
			graph = new int[n];
			visited = new boolean[n];
			distances = new int[n];

			for (int j = 1; j < n; j++) {
				graph[input.nextInt()] = input.nextInt();
			}

			int max = 0, maxPos =-1;
			for (int j = 1; j < n; j++) {
				if (distances[j] == 0) {
					dfs(j);
				}
				if (distances[j] > max) {
					maxPos = j;
					max = distances[j];
				}
			}
			System.out.printf("Case %d: %d\n",i,maxPos);
			
		}
	}

	private static int dfs(int u) {

		 visited[u] = true;
		    int tot = 0;
		    if(graph[u] != -1 && !visited[graph[u]])
		        tot += 1 + dfs(graph[u]);
		    visited[u] = false;
		    distances[u] = tot;
		  return tot;
	}

}
