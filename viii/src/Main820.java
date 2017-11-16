import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Usar algoritmo Edmond's Karp
 * Fuente https://github.com/phishman3579/java-algorithms-implementation/blob/master/src/com/jwetherell/algorithms/graph/EdmondsKarp.java
 * 
 *
 */
public class Main820 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer output = new StringBuffer();
		
		int networks = 0;
		int nodes;
		int source, destination, connections;
		while ( (nodes = Integer.parseInt(br.readLine())) != 0) {
			args = br.readLine().split(" ");
			
			source = Integer.parseInt(args[0]);
			destination = Integer.parseInt(args[1]);
			connections = Integer.parseInt(args[2]);
			
			EdmondsKarp edmondsKarp = new EdmondsKarp(nodes);
			
			while (connections --> 0) {
				args = br.readLine().split(" ");
				edmondsKarp.addEdge(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			}
			
			
			output.append("Network ");
			output.append(++networks);
			output.append("\n");
			output.append("The bandwidth is ");
			output.append(edmondsKarp.getMaxFlow(source, destination));
			output.append(".\n\n");
		}
		
		
		System.out.print(output);
		
	}

}

class EdmondsKarp {

    private long[][] flow; //max flow beetween i and j verticles
    private long[][] capacity; // edge capacity
    private int[] parent; //parent
    private boolean[] visited; //just for checking if visited
    private int n;
	
    public EdmondsKarp(int numOfVerticles) {
        this.n = numOfVerticles + 1;
        this.flow = new long[n][n];
        this.capacity = new long[n][n];
        this.parent = new int[n];
        this.visited = new boolean[n];
    }
    
    public void addEdge(int from, int to, long capacity) {
        assert capacity >= 0;
        this.capacity[from][to] += capacity;
        this.capacity[to][from] += capacity; //se agregó esta línea
    }

    /**
     * Get maximum flow.
     * 
     * @param s source
     * @param t target
     * @return maximum flow
     */
    public long getMaxFlow(int s, int t) {
        while (true) {
            final Queue<Integer> Q = new ArrayDeque<Integer>();
            Q.add(s);

            for (int i = 0; i < this.n; ++i)
                visited[i] = false;
            visited[s] = true;

            boolean check = false;
            int current;
            while (!Q.isEmpty()) {
                current = Q.peek();
                if (current == t) {
                    check = true;
                    break;
                }
                Q.remove();
                for (int i = 0; i < n; ++i) {
                    if (!visited[i] && capacity[current][i] > flow[current][i]) {
                        visited[i] = true;
                        Q.add(i);
                        parent[i] = current;
                    }
                }
            }
            if (check == false) 
                break;

            long temp = capacity[parent[t]][t] - flow[parent[t]][t];
            for (int i = t; i != s; i = parent[i])
                temp = Math.min(temp, (capacity[parent[i]][i] - flow[parent[i]][i]));

            for (int i = t; i != s; i = parent[i]) {
                flow[parent[i]][i] += temp;
                flow[i][parent[i]] -= temp;
            }
        }

        long result = 0;
        for (int i = 0; i < n; ++i)
            result += flow[s][i];
        return result;
    }

}
