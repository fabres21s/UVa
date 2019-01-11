import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main10044 {

	/**
	 * 10044 - The Tourist Guide
	 *
	 * Submission: 20145686 Date: 2017-10-09 19:32:49 Runtime: 0.120 Ranking: 3917
	 */
	public static int MAX = Integer.MAX_VALUE;

	/**
	 * - Dijkstra - Similar al 544 - Heavy Cargo
	 * 
	 * Encontrar en un grafo, el mayor valor entre los menores pesos de cada arista
	 * en los caminos para ir de A hasta B
	 * 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();


		int publications, queries;
		String line;

		int testCases = Integer.parseInt(br.readLine());
		for (int cases = 1; cases <= testCases; cases++) {
			args = br.readLine().split(" ");

			publications = Integer.parseInt(args[0]);
			queries = Integer.parseInt(args[1]);

			Grafo10044 grafo = new Grafo10044();
			grafo.init();
			for (int x = 0; x < publications; x++) {
				args = br.readLine().trim().split(":");
				String names[] = args[0].split("\\.[,\\:]");

				for (int i = 0; i < names.length - 1; i++) {
					for (int j = i + 1; j < names.length; j++) {
						grafo.addAdyacente(names[i].trim() + ".", names[j].trim() +  ((names[j].trim().endsWith(".")) ?"" : "."), 1);
					}
				}

			}
			grafo.getNodo("Erdos, P.").setRecorrido(0);
			grafo.solve(grafo.getNodo("Erdos, P."));
			output.append(String.format("Scenario %d\n", cases));
			for (int i = 0; i < queries; i++) {
				line = br.readLine();
				Nodo10044 nodo = grafo.getNodo(line);
				
				if (nodo == null) {
					output.append(String.format("%s infinity\n", line));
					continue;
				}
				
				int erdosNumber = nodo.getRecorrido();

				if (erdosNumber == Integer.MAX_VALUE) {
					output.append(String.format("%s infinity\n", line));
				} else {
					output.append(String.format("%s %d\n", line, erdosNumber));
				}

			}

		}
		System.out.print(output);
	}
}

class Grafo10044 {

	int max = Integer.MAX_VALUE;
	private List<Nodo10044> nodosEtiquetados;
	public String nodoFinal;
	Map<String, List<Nodo10044>> nodosExistentes;

	public void init() {

		nodosEtiquetados = new ArrayList<Nodo10044>();
		nodosExistentes = new HashMap<String, List<Nodo10044>>();
		max = Integer.MAX_VALUE;
	}

	public Nodo10044 getNodo(String origen) {
		if (nodosExistentes.get(origen) == null) {
			return null;
		}
		return nodosExistentes.get(origen).get(0);

	}

	public void addAdyacente(String origen, String destino, int peso) {

		Nodo10044 nodoOrigen = null;

		List<Nodo10044> nodos = nodosExistentes.get(origen);

		if (nodos == null) {
			nodoOrigen = crearNodo(origen);
			nodos = new ArrayList<Nodo10044>();
			nodos.add(nodoOrigen);
		} else {
			nodoOrigen = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista

		}
		nodosExistentes.put(origen, nodos);

		Nodo10044 nodoDestino = null;

		nodos = nodosExistentes.get(destino);

		if (nodos == null) {
			nodos = new ArrayList<Nodo10044>();
			nodoDestino = crearNodo(destino);
			nodos.add(nodoDestino);
		} else {
			nodoDestino = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista

		}

		nodosExistentes.put(destino, nodos);
		Arista10044 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);
		nodoDestino.getAristas().add(arista);
	}

	private Arista10044 crearArista(Nodo10044 nodoOrigen, Nodo10044 nodoDestino, int peso) {
		Arista10044 arista = new Arista10044();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		return arista;
	}

	private Nodo10044 crearNodo(String value) {
		Nodo10044 nodo = new Nodo10044();
		nodo.setValue(value);
		nodo.setRecorrido(max);
		nodo.setAristas(new ArrayList<Arista10044>());
		return nodo;
	}

	public void solve(Nodo10044 nodo) {

		nodosEtiquetados.remove(nodo);
		nodo.setVisitado(true);

		int max = Integer.MAX_VALUE;
		Nodo10044 siguiente = new Nodo10044();
		for (Arista10044 arista : nodo.getAristas()) {

			Nodo10044 nodoDestino = arista.getNodoDestino();

			if (!nodoDestino.isVisitado()) {

				nodosEtiquetados.remove(nodoDestino);
				nodoDestino.setRecorrido(Math.min(nodo.getRecorrido() + arista.getPeso(), nodoDestino.getRecorrido()));

				nodosEtiquetados.add(nodoDestino);
			}

			// por ser bidireccionales
			nodoDestino = arista.getNodoOrigen();

			if (!nodoDestino.isVisitado()) {
				nodosEtiquetados.remove(nodoDestino);

				nodoDestino.setRecorrido(Math.min(nodo.getRecorrido() + arista.getPeso(), nodoDestino.getRecorrido()));

				nodosEtiquetados.add(nodoDestino);
			}
		}

		for (Nodo10044 nodoEtiquetado : nodosEtiquetados) {
			if (nodoEtiquetado.getRecorrido() < max) {

				max = nodoEtiquetado.getRecorrido();
				siguiente = nodoEtiquetado;
			}
		}

		if (nodosEtiquetados.size() > 0) {

			nodosEtiquetados.remove(siguiente);

			solve(siguiente);

		}
	}
}

class Arista10044 {
	private Nodo10044 nodoOrigen;
	private Nodo10044 nodoDestino;
	private int peso;

	public Nodo10044 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo10044 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo10044 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo10044 nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}

class Nodo10044 {

	private String value;
	private List<Arista10044> aristas;
	private int recorrido = Integer.MAX_VALUE;
	private boolean visitado;
	// List<Integer> weights

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Arista10044> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista10044> aristas) {
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
		return "nodo = " + value + "; No erdos = " + recorrido;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

}
