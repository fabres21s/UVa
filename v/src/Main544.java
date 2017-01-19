import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main544 {

	/**
	*	544 - Heavy Cargo
	*
	*
	*	Submision:	18643608
	*	Date:		2017-01-18 19:56:32
	*	Runtime:	0.140
	*	Ranking:	2137
	*/
	public static int MAX = Integer.MAX_VALUE;


	/**
	 * - Dijkstra, pero lo contrario
	 * - Simulación
	 * 
	 * Dada una serie de ciudades interconectadas en ambos sentidos, cada uno de los tramos
	 * soporta un peso en toneladas, la tarea consiste en encontrar el camino para ir 
	 * desde A hasta B con la mayor cantidad de peso posible
	 * 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String city1, city2;
		int weight;
		int cities, roads;
		int cases = 0;
		while (!(line = br.readLine()).equals("0 0")) {
			cases++;
			args = line.split(" ");

			cities = Integer.parseInt(args[0]);
			roads = Integer.parseInt(args[1]);

			Grafo544 grafo544 = new Grafo544();
			grafo544.createNodes(cities);
			for (int i = 0; i < roads; i++) {
				args = br.readLine().split(" ");
				city1 = args[0];
				city2 = args[1];
				weight = Integer.parseInt(args[2]);

				grafo544.addAdyacente(city1, city2, weight);
			}

			args = br.readLine().split(" ");
			city1 = args[0];
			city2 = args[1];

			grafo544.setDestino(city2);
			grafo544.solve(grafo544.getNodo(city1));
			System.out.println("Scenario #"+cases);
			System.out.println(grafo544.getNodo(city2).getMinWeight()+" tons\n");

		}

	}
}

class Grafo544 {

	int max = Integer.MAX_VALUE;
	private List<Nodo544> nodosEtiquetados;
	public String nodoFinal;
	Map<String, List<Nodo544>> nodosExistentes;
	private String destino;

	public void createNodes(int qty) {

		nodosEtiquetados = new ArrayList<Nodo544>();
		nodosExistentes = new HashMap<String, List<Nodo544>>();
		max = Integer.MAX_VALUE;
	}

	public void setDestino(String city2) {
		this.destino = city2;

	}

	public Nodo544 getNodo(String origen) {

		return nodosExistentes.get(origen).get(0);

	}

	public void addAdyacente(String origen, String destino, int peso) {

		Nodo544 nodoOrigen = null;

		List<Nodo544> nodos = nodosExistentes.get(origen);

		if (nodos == null) {
			nodoOrigen = crearNodo(origen);
			nodos = new ArrayList<Nodo544>();
			nodos.add(nodoOrigen);
		} else {
			nodoOrigen = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista

		}
		nodosExistentes.put(origen, nodos);

		Nodo544 nodoDestino = null;

		nodos = nodosExistentes.get(destino);

		if (nodos == null) {
			nodos = new ArrayList<Nodo544>();
			nodoDestino = crearNodo(destino);
			nodos.add(nodoDestino);
		} else {
			nodoDestino = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista

		}

		nodosExistentes.put(destino, nodos);
		Arista544 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);
		nodoDestino.getAristas().add(arista);

	}

	private Arista544 crearArista(Nodo544 nodoOrigen, Nodo544 nodoDestino, int peso) {
		Arista544 arista = new Arista544();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		arista.setValida(true);

		return arista;
	}

	private Nodo544 crearNodo(String value) {
		Nodo544 nodo = new Nodo544();
		nodo.setValue(value);
		nodo.setRecorrido(max);
		nodo.setMinWeight(max);
		nodo.setAristas(new ArrayList<Arista544>());
		return nodo;
	}

	public void solve(Nodo544 nodo) {

		nodosEtiquetados.remove(nodo);
		nodo.setVisitado(true);

		int max = 0;
		Nodo544 siguiente = new Nodo544();
		for (Arista544 arista : nodo.getAristas()) {

			Nodo544 nodoDestino = arista.getNodoDestino();

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

		for (Nodo544 nodoEtiquetado : nodosEtiquetados) {
			if (nodoEtiquetado.getMinWeight() > max) {

				max = nodoEtiquetado.getMinWeight();
				siguiente = nodoEtiquetado;
			}
		}

		if (siguiente.equals(getNodo(destino))) {
			//System.out.println("se encontro el max "+siguiente.getMinWeight());
			//return;
		}
		
		if (nodosEtiquetados.size() > 0) {

			nodosEtiquetados.remove(siguiente);
			
			

			solve(siguiente);

		}
	}
}

class Arista544 {
	private Nodo544 nodoOrigen;
	private Nodo544 nodoDestino;
	private int peso;
	private boolean valida;
	private int linea;

	@Override
	public String toString() {
		return "origen = " + nodoOrigen.getValue() + " ; destino = " + nodoDestino.getValue() + " ; peso = " + peso
				+ " ; linea = " + linea;
	}

	public Nodo544 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo544 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo544 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo544 nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public boolean isValida() {
		return valida;
	}

	public void setValida(boolean valida) {
		this.valida = valida;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}
}

class Nodo544 {

	private String value;
	private List<Arista544> aristas;
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

	public List<Arista544> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista544> aristas) {
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
