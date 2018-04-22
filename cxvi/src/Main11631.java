import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
*	11631 - Dark roads
*
*	Submission:	21187127
*	Date:		2018-04-22 17:19:41
*	Runtime:	0.720
*	Ranking:	3218
*/
public class Main11631 {

	/**
	 * - Grafos bidireccionales 
	 * - Kruskal 
	 * - Recursividad
	 * 
	 * Hallar el árbol de expansión mínimo en un grafo
	 * Similar al 10034 - Esta es una más eficiente implementación
	 */

	static int[] f;
	static int n;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

	/**
	 * - Grafos bidireccionales 
	 * - Kruskal 
	 * - Recursividad
	 * 
	 * Hallar el árbol de expansión mínimo en un plano cartesiano en el que
	 * todos sus puntos se interconectan
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int conexiones, totalWeight;
		String line;
		int i;

		while (!(line = br.readLine()).equals("0 0")) {

			pq.clear();
			args = line.split(" ");

			n = Integer.parseInt(args[0]);
			conexiones = Integer.parseInt(args[1]);

			totalWeight = 0;
			for (i = 0; i < conexiones; i++) {
				args = br.readLine().split(" ");
				totalWeight += Integer.parseInt(args[2]);
				pq.offer(new Edge(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
			}

			output.append((totalWeight - kruskal()) + "\n");

		}
		System.out.print(output);

	}

	static int find(int x) {
		if (f[x] == -1)
			return x;
		return f[x] = find(f[x]);
	}

	private static int kruskal() {
		f = new int[n];
		Arrays.fill(f, -1);
		int total = 0;
		while (pq.size() != 0) {
			Edge e = pq.poll();
			int a = find(e.source);
			int b = find(e.destiny);
			if (a != b) {
				f[a] = b;
				total += e.weight;
			}
		}
		return total;
	}

}

class Edge implements Comparable<Edge> {
	public int source;
	public int destiny;
	public int weight;

	public Edge(int source, int destiny, int weight) {
		this.source = source;
		this.destiny = destiny;
		this.weight = weight;

	}

	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}
}