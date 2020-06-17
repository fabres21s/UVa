import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


/**
*	315 - Network
*
*
*	Submission:	22627914
*	Date:		2019-01-17 20:59:12
*	Runtime:	0.130
*	Ranking:	4977
*/
//Sacado de https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/

public class Main315 {

	/**
	 * - Grafos
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int points, centralPoint;
		String line;
		StringBuffer output = new StringBuffer();
		
		while ((points = Integer.parseInt(br.readLine())) != 0) {
			Graph graph = new Graph(points + 1);
			
			while (!(line = br.readLine()).equals("0")) {
				args = line.split(" ");
				centralPoint = Integer.parseInt(args[0]);
				
				for (int i = 1; i < args.length; i++) {
					graph.addEdge(centralPoint, Integer.parseInt(args[i]));
				}
				
			}
			output.append(String.format("%d\n", graph.AP()));
		}
		System.out.print(output);
	}

}

class Graph 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
    int time = 0; 
    static final int NIL = -1; 
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
        adj[w].add(v);    //Add v to w's list 
    } 
  
    // A recursive function that find articulation points using DFS 
    // u --> The vertex to be visited next 
    // visited[] --> keeps tract of visited vertices 
    // disc[] --> Stores discovery times of visited vertices 
    // parent[] --> Stores parent vertices in DFS tree 
    // ap[] --> Store articulation points 
    void APUtil(int u, boolean visited[], int disc[], 
                int low[], int parent[], boolean ap[]) 
    { 
  
        // Count of children in DFS Tree 
        int children = 0; 
  
        // Mark the current node as visited 
        visited[u] = true; 
  
        // Initialize discovery time and low value 
        disc[u] = low[u] = ++time; 
  
        // Go through all vertices aadjacent to this 
        Iterator<Integer> i = adj[u].iterator(); 
        while (i.hasNext()) 
        { 
            int v = i.next();  // v is current adjacent of u 
  
            // If v is not visited yet, then make it a child of u 
            // in DFS tree and recur for it 
            if (!visited[v]) 
            { 
                children++; 
                parent[v] = u; 
                APUtil(v, visited, disc, low, parent, ap); 
  
                // Check if the subtree rooted with v has a connection to 
                // one of the ancestors of u 
                low[u]  = Math.min(low[u], low[v]); 
  
                // u is an articulation point in following cases 
  
                // (1) u is root of DFS tree and has two or more chilren. 
                if (parent[u] == NIL && children > 1) 
                    ap[u] = true; 
  
                // (2) If u is not root and low value of one of its child 
                // is more than discovery value of u. 
                if (parent[u] != NIL && low[v] >= disc[u]) 
                    ap[u] = true; 
            } 
  
            // Update low value of u for parent function calls. 
            else if (v != parent[u]) 
                low[u]  = Math.min(low[u], disc[v]); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive function APUtil() 
    int AP() 
    { 
        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[V]; 
        int disc[] = new int[V]; 
        int low[] = new int[V]; 
        int parent[] = new int[V]; 
        boolean ap[] = new boolean[V]; // To store articulation points 
  
        // Initialize parent and visited, and ap(articulation point) 
        // arrays 
        for (int i = 0; i < V; i++) 
        { 
            parent[i] = NIL; 
            visited[i] = false; 
            ap[i] = false; 
        } 
  
        // Call the recursive helper function to find articulation 
        // points in DFS tree rooted with vertex 'i' 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                APUtil(i, visited, disc, low, parent, ap); 
  
        // Now ap[] contains articulation points, print them 
        int count = 0;
        for (int i = 0; i < V; i++) 
            if (ap[i] == true) 
                count++;
        return count;
    } 
}
