import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
*	12144 - Almost Shortest Path
*
*
*	Submision:	20146688
*	Date:		2017-10-10 02:53:30
*	Runtime:	0.330
*	Ranking:	328
*/
public class Main12144 {

	/**
	 * - Dijkstra con arreglos 
	 * 
	 * Creo que consiste en encontrar la segunda ruta más corta, no me queda muy claro
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		String line;
		while (!(line = br.readLine()).equals("0 0")) {
			args = line.split(" ");
			int points = Integer.parseInt(args[0]);
			int routes = Integer.parseInt(args[1]);

			args = br.readLine().split(" ");
			int startPoint = Integer.parseInt(args[0]);
			int endPoint = Integer.parseInt(args[1]);

			int grafo[][] = new int[points][points];
			int grafoTrans[][] = new int[points][points];

			int distances[] = new int[points];
			int distancesTrans[] = new int[points];

			Arrays.fill(distances, Integer.MAX_VALUE);
			Arrays.fill(distancesTrans, Integer.MAX_VALUE);

			for (int i = 0; i < routes; i++) {
				args = br.readLine().split(" ");
				int initialPoint = Integer.parseInt(args[0]);
				int finalPoint = Integer.parseInt(args[1]);
				int weight = Integer.parseInt(args[2]);

				grafo[initialPoint][finalPoint] = weight;
				grafoTrans[finalPoint][initialPoint] = weight;
			}

			distances = dijkstra(startPoint, grafo, distances);

			int minDist = distances[endPoint];
			if (minDist == Integer.MAX_VALUE) {
				output.append("-1\n");
				continue;
			}

			distancesTrans = dijkstra(endPoint, grafoTrans, distancesTrans);

			for (int i = 0; i < points; i++) {
				for (int j = 0; j < points; j++) {
					if (grafo[i][j] > 0) {
						if (distances[i] + grafo[i][j] + distancesTrans[j] == minDist)
							grafo[i][j] = 0;
					}
				}
			}

			Arrays.fill(distances, Integer.MAX_VALUE);
			distances = dijkstra(startPoint, grafo, distances);
			output.append(distances[endPoint] == Integer.MAX_VALUE ? -1 : distances[endPoint]);
			output.append("\n");

		}
		System.out.print(output);
	}

	private static int[] dijkstra(int startPoint, int[][] grafo, int[] distances) {
		boolean mark[] = new boolean[distances.length];
		distances[startPoint] = 0;
		int v;
		while ((v = getMin(distances, mark)) != -1) {
			mark[v] = true;
			for (int w = 0; w < distances.length; w++) {
				if (grafo[v][w] > 0 && !mark[w] && (distances[v] + grafo[v][w] < distances[w])) {
					distances[w] = distances[v] + grafo[v][w];
				}
			}
		}

		return distances;
	}

	private static int getMin(int[] distances, boolean[] mark) {
		int ret = -1, min = Integer.MAX_VALUE;
		for (int i = 0; i < distances.length; i++) {
			if (!mark[i] && distances[i] < min) {
				min = distances[i];
				ret = i;
			}
		}

		return ret;
	}

}
