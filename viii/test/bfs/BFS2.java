package bfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Algoritmo para búsqueda en profundidad sin importar sin son grafos uni o bidireccionales
 * está un caso muy particular
 * 
 * @author fabio
 *
 */
public class BFS2 {

	public static void main(String[] args) {
		Grafo820 grafo = new Grafo820();
		grafo.createNodes(4);
		grafo.addAdyacente(0, 1, 20);
		grafo.addAdyacente(1, 0, 20);
		
		grafo.addAdyacente(0, 2, 10);
		grafo.addAdyacente(2, 0, 10);
		
		grafo.addAdyacente(1, 2, 5);
		grafo.addAdyacente(2, 1, 5);
		
		grafo.addAdyacente(1, 3, 10);
		grafo.addAdyacente(3, 1, 10);
		
		grafo.addAdyacente(2, 3, 20);
		grafo.addAdyacente(3, 2, 20);

		boolean visited[] = new boolean[4];
		grafo.solve(0, visited, "0", -1);
	}

}

 class Grafo820 {

	List<Nodo820> nodos;
	int arreglo[];

	public void createNodes(int qty) {
		nodos = new ArrayList<Nodo820>();

		for (int i = 0; i < qty; i++) {
			Nodo820 nodo = new Nodo820();

			nodo.setValue(i);
			nodo.setAristas(new ArrayList<Arista820>());
			nodos.add(nodo);
		}
		arreglo = new int[qty];

	}

	public void addAdyacente(int origen, int destino, int peso) {
		Nodo820 nodoOrigen = nodos.get(origen);
		Nodo820 nodoDestino = nodos.get(destino);
		Arista820 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);
		nodoDestino.getAristas().add(arista);
		
	}
	
	private Arista820 crearArista(Nodo820 nodoOrigen, Nodo820 nodoDestino, int peso) {
		Arista820 arista = new Arista820();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		return arista;
	}

	public void solve(int source, boolean[] visited, String path, int peso) {

		if (source == 3) {
			System.out.println(path + " ::: "+peso);
		}
		Nodo820 nodoOrigen = nodos.get(source);
		visited[source] = true;
		boolean v[] = Arrays.copyOf(visited, visited.length);

		// buscamos los adyacentes

		for (Arista820 arista: nodoOrigen.getAristas()) {
			if (!visited[arista.getNodoDestino().getValue()]) {
				solve(arista.getNodoDestino().getValue(), v, path + String.valueOf(arista.getNodoDestino().getValue()), arista.getPeso());
			}
		}

	}

}

class Nodo820 {

	private int value;
	private List<Arista820> aristas; 
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Arista820> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista820> aristas) {
		this.aristas = aristas;
	}

}


class Arista820 {
	private Nodo820 nodoOrigen;
	private Nodo820 nodoDestino;
	private int peso;

	public Nodo820 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo820 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo820 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo820 nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
}