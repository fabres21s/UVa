import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
*	532 - Dungeon Master
*
*
*	Submision:	17618497
*	Date:		2016-07-04 16:07:10
*	Runtime:	0.310
*	Ranking:	4288
*/
public class Main532 {

	/**
	 * - Dijkstra con Arreglos
	 * - Priority Queue
	 * - Arreglos 
	 * 
	 * El ejercicio consiste en que dado un arreglo tridimensional, con una posición inicial
	 * y una posición final, encontrar la ruta más corta para llegar desde S hasta E
	 * con ciertas condiciones
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int dimensions, rows, columns;
		int i, j, k;
		while (!(line = br.readLine()).equals("0 0 0")) {
			args = line.split(" ");
			dimensions = Integer.parseInt(args[0]);
			rows = Integer.parseInt(args[1]);
			columns = Integer.parseInt(args[2]);

			char[][][] array = new char[dimensions + 2][rows + 2][columns + 2];
			for (i = 1; i <= dimensions; i++) {
				for (j = 1; j <= rows; j++) {
					char[] lineChar = br.readLine().toCharArray();
					for (k = 1; k <= columns; k++) {
						array[i][j][k] = lineChar[k - 1];
					}
				}
					br.readLine();
			}

			Grafo grafo = new Grafo();
			for (i = 1; i <= dimensions; i++) {
				for (j = 1; j <= rows; j++) {
					for (k = 1; k <= columns; k++) {
						if (array[i][j][k - 1] == '.'
								|| array[i][j][k - 1] == 'E') {
							grafo.addAdyacente(i, j, k, array[i][j][k], i, j,
									k - 1, array[i][j][k - 1]);
						}
						if (array[i][j][k + 1] == '.'
								|| array[i][j][k + 1] == 'E') {
							grafo.addAdyacente(i, j, k, array[i][j][k], i, j,
									k + 1, array[i][j][k + 1]);
						}
						if (array[i][j + 1][k] == '.'
								|| array[i][j + 1][k] == 'E') {
							grafo.addAdyacente(i, j, k, array[i][j][k], i,
									j + 1, k, array[i][j + 1][k]);
						}
						if (array[i][j - 1][k] == '.'
								|| array[i][j - 1][k] == 'E') {
							grafo.addAdyacente(i, j, k, array[i][j][k], i,
									j - 1, k, array[i][j - 1][k]);
						}
						if (array[i + 1][j][k] == '.'
								|| array[i + 1][j][k] == 'E') {
							grafo.addAdyacente(i, j, k, array[i][j][k], i + 1,
									j, k, array[i + 1][j][k]);
						}
						if (array[i - 1][j][k] == '.'
								|| array[i - 1][j][k] == 'E') {
							grafo.addAdyacente(i, j, k, array[i][j][k], i - 1,
									j, k, array[i - 1][j][k]);
						}
					}
				}
			}

			if (grafo.getNodoInicial() == null) {
			System.out.println("Trapped!");
		} else if (grafo.getNodoFinal() == null) {
			System.out.println("Trapped!");
		} else {
			List<Arista> aristas = grafo.getNodoInicial().getAristas();
			Coordenada coordenada = grafo.getNodoInicial().getCoordenada();
			boolean visited[][][] = new boolean[dimensions + 2][rows + 2][columns + 2];
			visited[coordenada.getX()][coordenada.getY()][coordenada.getZ()] = true;
			int distances[][][] = new int[dimensions + 2][rows + 2][columns + 2];

			PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();

			for (Arista arista : aristas) {
				priorityQueue.add(new Item(arista.getNodoFinal()
						.getCoordenada(), arista.getPeso()));
			//	priorityQueue.add(new Item(arista.getNodoOrigen()
				//		.getValue(), arista.getPeso()));
			}

			while (priorityQueue.size() > 0) {
				Item item = priorityQueue.poll();
				coordenada = item.getCoordenada();
				if (!visited[coordenada.getX()][coordenada.getY()][coordenada.getZ()]) {
					visited[coordenada.getX()][coordenada.getY()][coordenada.getZ()] = true;
					distances[coordenada.getX()][coordenada.getY()][coordenada.getZ()] = item.getDistance();
					
					aristas = grafo.getNodosExistentes().get(item.getCoordenada().toString()).getAristas();

					for (Arista arista : aristas) {
						coordenada = arista.getNodoFinal().getCoordenada();
						if (!visited[coordenada.getX()][coordenada.getY()][coordenada.getZ()]) {
							priorityQueue.add(new Item(arista
									.getNodoFinal().getCoordenada(), item
									.getDistance() + arista.getPeso()));

						}
//						if (!visited[arista.getNodoDestino().getValue()]) {
//							priorityQueue.add(new Item(arista
//									.getNodoDestino().getValue(), item
//									.getDistance() + arista.getPeso()));
//
//						}

					}
				}
			}
			
			coordenada = grafo.getNodoFinal().getCoordenada();
			if (distances[coordenada.getX()][coordenada.getY()][coordenada.getZ()] == 0) {
				System.out.println("Trapped!");
			} else {
				System.out.printf("Escaped in %d minute(s).\n", 
						distances[coordenada.getX()][coordenada.getY()][coordenada.getZ()]);
			}
		}
//			grafo.solve(grafo.getNodoInicial(), 0);
//			if (grafo.getNodoInicial() == null) {
//				System.out.println("Trapped!");
//			} else if (grafo.getNodoFinal() == null) {
//				System.out.println("Trapped!");
//			} else if (grafo.getNodoFinal().getRecorrido() == Integer.MAX_VALUE) {
//				System.out.println("Trapped!");
//			} else {
//
//				System.out.printf("Escaped in %d minute(s).\n", grafo
//						.getNodoFinal().getRecorrido());
//			}
		}
	}
}

class Grafo {

	Nodo nodoInicial, nodoFinal;
	Map<String, Nodo> nodosExistentes = new HashMap<String, Nodo>();
	private List<Nodo> nodosEtiquetados = new ArrayList<Nodo>();

	public Nodo getNodoInicial() {
		return nodoInicial;
	}

	public void setNodoInicial(Nodo nodoInicial) {
		this.nodoInicial = nodoInicial;
	}

	public Nodo getNodoFinal() {
		return nodoFinal;
	}

	public void setNodoFinal(Nodo nodoFinal) {
		this.nodoFinal = nodoFinal;
	}

	public Map<String, Nodo> getNodosExistentes() {
		return nodosExistentes;
	}

	public void setNodosExistentes(Map<String, Nodo> nodosExistentes) {
		this.nodosExistentes = nodosExistentes;
	}

	public List<Nodo> getNodosEtiquetados() {
		return nodosEtiquetados;
	}

	public void setNodosEtiquetados(List<Nodo> nodosEtiquetados) {
		this.nodosEtiquetados = nodosEtiquetados;
	}

	public void addAdyacente(int i, int j, int k, char value, int i2, int j2,
			int k2, char value2) {

		Nodo nodoOrigen = validate(i, j, k, value);
		Nodo nodoFinal = validate(i2, j2, k2, value2);

		nodoOrigen.getAristas().add(new Arista(nodoOrigen, nodoFinal, 1));

	}

	private Nodo validate(int i, int j, int k, char value) {
		Coordenada coordenada = new Coordenada(i, j, k);
		Nodo nodo = nodosExistentes.get(coordenada.toString());

		if (nodo == null) {
			nodo = new Nodo();
			nodo.setCoordenada(coordenada);
			nodo.setValue(value);

			if (value == 'S') {
				nodoInicial = nodo;
				nodoInicial.setRecorrido(0);
			} else if (value == 'E') {
				nodoFinal = nodo;
			}
			nodosExistentes.put(coordenada.toString(), nodo);

		}
		return nodo;
	}

	public void solve(Nodo nodo, int recorridoPrevio) {

		if (nodo != null) {
			System.out.println(nodosEtiquetados.size());
			nodosEtiquetados.remove(nodo);
			nodo.setVisitado(true);

			int min = Integer.MAX_VALUE;
			Nodo siguiente = new Nodo();
			for (Arista arista : nodo.getAristas()) {

				Nodo nodoDestino = arista.getNodoFinal();

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

				// List<Nodo> nodos = nodosExistentes.get(nodoFinal);
				//
				// if (nodos == null) {
				// System.out.println("IMPOSSIBLE");
				// } else {
				// boolean impossible = false;
				// min = Integer.MAX_VALUE;
				// for (Nodo nodoF : nodos) {
				// if (!nodoF.isVisitado()) {
				// impossible = true;
				// break;
				// }
				// min = Math.min(min, nodoF.getRecorrido());
				// }
				// if (impossible) {
				// System.out.println("IMPOSSIBLE");
				// } else {
				// System.out.println(min);
				// }
				// }
			}
		}
	}
}

class Coordenada {
	int x, y, z;

	public Coordenada(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + z;
	}
}

class Arista {
	public Nodo nodoOrigen, nodoFinal;
	public int peso;

	public Arista(Nodo nodoOrigen, Nodo nodoFinal, int peso) {
		this.nodoFinal = nodoFinal;
		this.nodoOrigen = nodoOrigen;
		this.peso = peso;
	}

	public Nodo getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo getNodoFinal() {
		return nodoFinal;
	}

	public void setNodoFinal(Nodo nodoFinal) {
		this.nodoFinal = nodoFinal;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}

class Nodo {

	Coordenada coordenada;
	char value;
	private List<Arista> aristas;
	private boolean visitado;
	private int recorrido;
	private Integer max = Integer.MAX_VALUE;

	public Nodo() {
		setAristas(new ArrayList<Arista>());
		setVisitado(false);
		setRecorrido(max);
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public List<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista> aristas) {
		this.aristas = aristas;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}
}

class Item implements Comparable<Item> {

	private Coordenada coordenada;
	private int distance;

	@Override
	public int compareTo(Item o) {
		return this.distance - o.distance;
	}


	public Item(Coordenada coordenada, int distance) {
		setCoordenada(coordenada);
		setDistance(distance);
	}



	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}


	public Coordenada getCoordenada() {
		return coordenada;
	}


	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
}
