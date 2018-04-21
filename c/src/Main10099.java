import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main10099 {

	/**
	 * 10099 - The Tourist Guide
	 *
	 * Submission: 	20145686 
	 * Date: 		2017-10-09 19:32:49 
	 * Runtime: 	0.120 
	 * Ranking: 	3917
	 */
	public static int MAX = Integer.MAX_VALUE;

	/**
	 * - Dijkstra
	 * - Similar al 544 - Heavy Cargo
	 * 
	 * Encontrar en un grafo, el mayor valor entre los menores pesos de cada arista en los caminos para ir de A hasta B 
	 * 
	 */
	public static void main(String[] args) throws IOException {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line;
			String city1, city2;
			int maxPassengers;
			int cities, roads;
			int cases = 0;
			int totalPassengers;
			int trips;
			while (!(line = br.readLine()).equals("0 0")) {
				cases++;
				args = line.split(" ");

				cities = Integer.parseInt(args[0]);
				roads = Integer.parseInt(args[1]);

				Grafo10099 grafo = new Grafo10099();
				grafo.createNodes(cities);
				for (int i = 0; i < roads; i++) {
					args = br.readLine().split(" ");
					city1 = args[0];
					city2 = args[1];
					maxPassengers = Integer.parseInt(args[2]);

					grafo.addAdyacente(city1, city2, maxPassengers);
				}

				args = br.readLine().split(" ");
				city1 = args[0];
				city2 = args[1];
				totalPassengers = Integer.parseInt(args[2]);

				grafo.setDestino(city2);
				grafo.solve(grafo.getNodo(city1));
				System.out.println("Scenario #" + cases);

				int minWeight = grafo.getNodo(city2).getMinWeight();

				trips = totalPassengers / (minWeight - 1);

				if (totalPassengers % (minWeight - 1) != 0) {
					trips++;
				}

				System.out.println("Minimum Number of Trips = " + trips + "\n");

			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}

class Grafo10099 {

	int max = Integer.MAX_VALUE;
	private List<Nodo10099> nodosEtiquetados;
	public String nodoFinal;
	Map<String, List<Nodo10099>> nodosExistentes;
	private String destino;

	public void createNodes(int qty) {

		nodosEtiquetados = new ArrayList<Nodo10099>();
		nodosExistentes = new HashMap<String, List<Nodo10099>>();
		max = Integer.MAX_VALUE;
	}

	public void setDestino(String city2) {
		this.destino = city2;

	}

	public Nodo10099 getNodo(String origen) {

		return nodosExistentes.get(origen).get(0);

	}

	public void addAdyacente(String origen, String destino, int peso) {

		Nodo10099 nodoOrigen = null;

		List<Nodo10099> nodos = nodosExistentes.get(origen);

		if (nodos == null) {
			nodoOrigen = crearNodo(origen);
			nodos = new ArrayList<Nodo10099>();
			nodos.add(nodoOrigen);
		} else {
			nodoOrigen = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista

		}
		nodosExistentes.put(origen, nodos);

		Nodo10099 nodoDestino = null;

		nodos = nodosExistentes.get(destino);

		if (nodos == null) {
			nodos = new ArrayList<Nodo10099>();
			nodoDestino = crearNodo(destino);
			nodos.add(nodoDestino);
		} else {
			nodoDestino = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista

		}

		nodosExistentes.put(destino, nodos);
		Arista10099 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);
		nodoDestino.getAristas().add(arista);
	}

	private Arista10099 crearArista(Nodo10099 nodoOrigen, Nodo10099 nodoDestino, int peso) {
		Arista10099 arista = new Arista10099();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		return arista;
	}

	private Nodo10099 crearNodo(String value) {
		Nodo10099 nodo = new Nodo10099();
		nodo.setValue(value);
		nodo.setRecorrido(max);
		nodo.setMinWeight(max);
		nodo.setAristas(new ArrayList<Arista10099>());
		return nodo;
	}

	public void solve(Nodo10099 nodo) {

		nodosEtiquetados.remove(nodo);
		nodo.setVisitado(true);

		int max = 0;
		Nodo10099 siguiente = new Nodo10099();
		for (Arista10099 arista : nodo.getAristas()) {

			Nodo10099 nodoDestino = arista.getNodoDestino();

			if (!nodoDestino.isVisitado()) {

				nodosEtiquetados.remove(nodoDestino);
				nodoDestino.setMinWeight(Math.min(nodo.getMinWeight(), arista.getPeso()));

				nodosEtiquetados.add(nodoDestino);
			}

			// por ser bidireccionales
			nodoDestino = arista.getNodoOrigen();

			if (!nodoDestino.isVisitado()) {
				nodosEtiquetados.remove(nodoDestino);

				nodoDestino.setMinWeight(Math.min(nodo.getMinWeight(), arista.getPeso()));

				nodosEtiquetados.add(nodoDestino);
			}
		}

		for (Nodo10099 nodoEtiquetado : nodosEtiquetados) {
			if (nodoEtiquetado.getMinWeight() > max) {

				max = nodoEtiquetado.getMinWeight();
				siguiente = nodoEtiquetado;
			}
		}

		if (nodosEtiquetados.size() > 0) {

			nodosEtiquetados.remove(siguiente);

			solve(siguiente);

		}
	}
}

class Arista10099 {
	private Nodo10099 nodoOrigen;
	private Nodo10099 nodoDestino;
	private int peso;

	public Nodo10099 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo10099 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo10099 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo10099 nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}

class Nodo10099 {

	private String value;
	private List<Arista10099> aristas;
	private int recorrido;
	private int minWeight = 0;
	private boolean visitado;
	// List<Integer> weights

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Arista10099> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista10099> aristas) {
		this.aristas = aristas;
	}

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}

	@Override
	public String toString() {
		return "nodo = " + value + "; min = " + minWeight;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(int minWeight) {

		if (minWeight > this.minWeight || this.minWeight == Integer.MAX_VALUE) {
			this.minWeight = minWeight;
		}
	}

}
