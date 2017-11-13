package bfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Algoritmo para búsqueda en profundidad sin importar sin son grafos uni o bidireccionales
 * está un caso muy particular
 * 
 * @author fabio
 *
 */
public class BFS {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.createNodes(4);
		grafo.addAdyacente(0, 1);
		grafo.addAdyacente(1, 0);
		
		grafo.addAdyacente(0, 2);
		grafo.addAdyacente(2, 0);
		
		grafo.addAdyacente(1, 2);
		grafo.addAdyacente(2, 1);
		
		grafo.addAdyacente(1, 3);
		grafo.addAdyacente(3, 1);
		
		grafo.addAdyacente(2, 3);
		grafo.addAdyacente(3, 2);

		boolean visited[] = new boolean[4];
		grafo.solve(0, visited, "0");
	}

}

class Grafo {

	List<Nodo> nodos;
	int arreglo[];
	private Map<String, boolean[]> map;

	public void createNodes(int qty) {
		nodos = new ArrayList<Nodo>();
		map = new HashMap<String, boolean[]>();

		for (int i = 0; i < qty; i++) {
			Nodo nodo = new Nodo();

			nodo.setValue(i);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
		}
		arreglo = new int[qty];

	}

	public void addAdyacente(int origen, int destino) {
		Nodo nodoOrigen = nodos.get(origen);
		Nodo nodoDestino = nodos.get(destino);
		nodoOrigen.getAdyacentes().add(nodoDestino);
	}

	public void solve(int source, boolean[] visited, String path) {

		if (source == 3) {
			System.out.println(path);
		}
		Nodo nodoOrigen = nodos.get(source);
		visited[source] = true;
		map.put(path, visited);
		boolean v[] = Arrays.copyOf(visited, visited.length);

		// buscamos los adyacentes

		for (Nodo nodo : nodoOrigen.getAdyacentes()) {
			if (!visited[nodo.getValue()]) {
				solve(nodo.getValue(), v, path + String.valueOf(nodo.getValue()));
			}
		}

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
