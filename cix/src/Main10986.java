import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
*	10986 - Sending Email
*
*
*	Submision:	17473196
*	Date:		2016-06-05 22:00:24
*	Runtime:	1.520
*	Ranking:	3561
*/
public class Main10986 {

	
	/**
	 * - Dijkstra
	 * -  Priority Queue
	 * 
	 * Implementación del algoritmo Dijkstra, no se pueden usar arreglos ya que la entrada
	 * es de 20000 registros, lo cual provoca un Java heap space y tampoco es posible
	 * usar el método solve de la clase Grafo, porque arroja un TLE, así que tocó hacer 
	 * un híbrido entre ellos.
	 * 
	 * El ejercicio consiste en que dada una red de computadores, unas conexiones, un origen y un destino,
	 * encontrar la ruta más corta.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testCases = input.nextInt();
		int servidores, conexiones, origen;
		for (int i = 1; i <= testCases; i++) {

			Grafo grafo = new Grafo();

			servidores = input.nextInt();
			grafo.createNodes(servidores);

			conexiones = input.nextInt();
			origen = input.nextInt();
			grafo.nodoFinal = input.nextInt();

			for (int j = 0; j < conexiones; j++) {
				grafo.addAdyacente(input.nextInt(), input.nextInt(),
						input.nextInt());
			}
			if (grafo.getInicial(origen) != null) {
				List<Arista> aristas = grafo.getInicial(origen).getAristas();

				boolean visited[] = new boolean[servidores];
				visited[origen] = true;
				int distances[] = new int[servidores];

				PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();

				for (Arista arista : aristas) {
					priorityQueue.add(new Item(arista.getNodoDestino()
							.getValue(), arista.getPeso()));
					priorityQueue.add(new Item(arista.getNodoOrigen()
							.getValue(), arista.getPeso()));
				}

				while (priorityQueue.size() > 0) {
					Item item = priorityQueue.poll();
					if (!visited[item.getRow()]) {
						visited[item.getRow()] = true;
						distances[item.getRow()] = item.getDistance();
						aristas = grafo.getInicial(item.getRow()).getAristas();

						for (Arista arista : aristas) {
							if (!visited[arista.getNodoOrigen().getValue()]) {
								priorityQueue.add(new Item(arista
										.getNodoOrigen().getValue(), item
										.getDistance() + arista.getPeso()));

							}
							if (!visited[arista.getNodoDestino().getValue()]) {
								priorityQueue.add(new Item(arista
										.getNodoDestino().getValue(), item
										.getDistance() + arista.getPeso()));

							}

						}
					}
				}
				if (distances[grafo.nodoFinal] == 0) {
					System.out.printf("Case #%d: unreachable\n", i);
				} else {
					System.out.printf("Case #%d: %d\n", i,
							distances[grafo.nodoFinal]);
				}
			} else {
				System.out.printf("Case #%d: unreachable\n", i);
			}
			
		}
		input.close();
	}
}

class Item implements Comparable<Item> {

	private int row;
	private int distance;

	@Override
	public int compareTo(Item o) {
		return this.distance - o.distance;
	}

	@Override
	public String toString() {
		return row + " ::: " + " ::: " + distance;
	}

	public Item(int row, int distance) {
		setRow(row);
		setDistance(distance);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}

class Grafo {

	int max = Integer.MAX_VALUE;
	int friendship;
	private List<Nodo> nodosEtiquetados;
	public int nodoFinal;
	Map<Integer, List<Nodo>> nodosExistentes;

	public void createNodes(int qty) {

		nodosEtiquetados = new ArrayList<Nodo>();
		nodosExistentes = new HashMap<Integer, List<Nodo>>();
		max = Integer.MAX_VALUE;
	}

	public Nodo getInicial(int inicial) {
		List<Nodo> nodos = nodosExistentes.get(inicial);
		if (nodos != null) {
			for (Nodo nodo : nodos) {
				nodo.setRecorrido(0);
				nodosEtiquetados.add(nodo);
			}

			return nodos.get(0);
		}
		return null;
	}

	public void addAdyacente(int origen, int destino, int peso) {

		Nodo nodoOrigen = null;

		List<Nodo> nodos = nodosExistentes.get(origen);

		if (nodos == null) {
			nodoOrigen = crearNodo(origen);
			nodos = new ArrayList<Nodo>();
			nodos.add(nodoOrigen);
		} else {
			nodoOrigen = nodos.get(0);
		}
		nodosExistentes.put(origen, nodos);

		Nodo nodoDestino = null;

		nodos = nodosExistentes.get(destino);

		if (nodos == null) {
			nodos = new ArrayList<Nodo>();
			nodoDestino = crearNodo(destino);
			nodos.add(nodoDestino);
		} else {
			nodoDestino = nodos.get(0);
		}

		nodosExistentes.put(destino, nodos);
		Arista arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);
		nodoDestino.getAristas().add(arista);

	}

	private Arista crearArista(Nodo nodoOrigen, Nodo nodoDestino, int peso) {
		Arista arista = new Arista();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		arista.setValida(true);

		return arista;
	}

	private Nodo crearNodo(int value) {
		Nodo nodo = new Nodo();
		nodo.setValue(value);
		nodo.setRecorrido(max);
		nodo.setAristas(new ArrayList<Arista>());
		return nodo;
	}

	public void solve(Nodo nodo, int recorridoPrevio) {

		if (nodo != null) {
			nodosEtiquetados.remove(nodo);

			nodo.setVisitado(true);

			// 0 20 2000 3
			// 0 20 1000 2
			// 0 10 100 1
			// 10 30 200 1
			// 30 40 100 1
			// 20 30 500 2
			// 20 50 3000 3

			int min = Integer.MAX_VALUE;
			Nodo siguiente = new Nodo();
			for (Arista arista : nodo.getAristas()) {

				Nodo nodoDestino = arista.getNodoDestino();

				if (!nodoDestino.isVisitado()) {

					if (arista.getPeso() + recorridoPrevio < nodoDestino
							.getRecorrido()) {
						nodosEtiquetados.remove(nodoDestino);
						nodoDestino.setRecorrido(arista.getPeso()
								+ recorridoPrevio);
						nodosEtiquetados.add(nodoDestino);
					}
				}
				// por ser bidireccionales
				nodoDestino = arista.getNodoOrigen();

				if (!nodoDestino.isVisitado()) {
					if (arista.getPeso() + recorridoPrevio < nodoDestino
							.getRecorrido()) {
						nodosEtiquetados.remove(nodoDestino);
						nodoDestino.setRecorrido(arista.getPeso()
								+ recorridoPrevio);
						nodosEtiquetados.add(nodoDestino);
					}
				}
			}

			for (Nodo nodoEtiquetado : nodosEtiquetados) {
				if (nodoEtiquetado.getRecorrido() < min) {

					min = nodoEtiquetado.getRecorrido();
					siguiente = nodoEtiquetado;
				}
			}

			if (nodosEtiquetados.size() > 0) {

				nodosEtiquetados.remove(siguiente);

				solve(siguiente, siguiente.getRecorrido());

			} else {

				List<Nodo> nodos = nodosExistentes.get(nodoFinal);

				if (nodos == null) {
					System.out.println("unreachable");
				} else {
					boolean impossible = false;
					min = Integer.MAX_VALUE;
					for (Nodo nodoF : nodos) {
						if (!nodoF.isVisitado()) {
							impossible = true;
							break;
						}
						min = Math.min(min, nodoF.getRecorrido());
					}
					if (impossible) {
						System.out.println("unreachable");
					} else {
						System.out.println(min);
					}
				}
			}
		} else {
			System.out.println("unreachable");
		}
	}
}

class Arista {
	private Nodo nodoOrigen;
	private Nodo nodoDestino;
	private int peso;
	private boolean valida;

	@Override
	public String toString() {
		return "origen = " + nodoOrigen.getValue() + " ; destino = "
				+ nodoDestino.getValue() + " ; peso = " + peso;
	}

	public Nodo getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo nodoDestino) {
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
}

class Nodo {

	private int value;
	private List<Arista> aristas;
	private int recorrido;
	private boolean visitado;
	private int linea;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista> aristas) {
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
		return "nodo = " + value + "; recorrido = " + recorrido + " ; linea="
				+ linea;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

}
