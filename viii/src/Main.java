import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Usar algoritmo Edmond's Karp
 * 
 *
 */
public class Main {

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
			
			Grafo grafo  = new Grafo();
			grafo.createNodes(nodes);
			grafo.setNodoFinal(destination);
			
			while (connections --> 0) {
				args = br.readLine().split(" ");
				grafo.addAdyacente(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			}
			boolean visited[] = new boolean[nodes + 1];
			grafo.solve(source, visited, String.valueOf(source));
			
			
			output.append("Network ");
			output.append(++networks);
			output.append("\n");
			output.append("The bandwidth is ");
			output.append(grafo.printSolution());
			output.append(".\n\n");
		}
		
		

		
	}

}

class Grafo {

	private List<Nodo> nodos;
	int arreglo[];
	private Map<String, Integer> mapWeights;
	private List<String> paths;
	private int nodoFinal;
	
	
	public void createNodes(int qty) {
		nodos = new ArrayList<Nodo>();
		mapWeights = new HashMap<String, Integer>();
		paths = new ArrayList<String>();
		
		for (int i = 0; i <= qty; i++) {
			Nodo nodo = new Nodo();

			nodo.setValue(i);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
		}
		arreglo = new int[qty];

	}

	public int printSolution() {
		
		int bandWidth = 0;
		
		for (String path : paths) {
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < path.length() - 1; i++) {
				
				min = Math.min(min, mapWeights.get(path.substring(i, i + 2)));
			}
			bandWidth += min;
		}
		return bandWidth;
	}

	public void addAdyacente(int origen, int destino, int weight) {
		Nodo nodoOrigen = nodos.get(origen);
		Nodo nodoDestino = nodos.get(destino);
		nodoOrigen.getAdyacentes().add(nodoDestino);
		nodoDestino.getAdyacentes().add(nodoOrigen);
		
		
		String source = String.valueOf(origen);
		String destination = String.valueOf(destino);
		mapWeights.put(source + "-" + destination, weight);
		mapWeights.put(destination + "-" + source, weight);
		
	}

	public void solve(int source, boolean[] visited, String path) {

		if (source == getNodoFinal()) {
			System.out.println(path);
			paths.add(path);
			return;
		}
		Nodo nodoOrigen = nodos.get(source);
		visited[source] = true;
		boolean v[] = Arrays.copyOf(visited, visited.length);

		// buscamos los adyacentes

		for (Nodo nodo : nodoOrigen.getAdyacentes()) {
			if (!visited[nodo.getValue()]) {
				solve(nodo.getValue(), v, path + " - " +String.valueOf(nodo.getValue()));
			}
		}

	}

	public int getNodoFinal() {
		return nodoFinal;
	}

	public void setNodoFinal(int nodoFinal) {
		this.nodoFinal = nodoFinal;
	}

}

class Nodo {

	private int value;
	private List<Nodo> adyacentes;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Nodo> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(List<Nodo> adyacentes) {
		this.adyacentes = adyacentes;
	}

}
