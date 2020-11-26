import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
*	10067 - Playing with Wheels
*
*
*	Submission:	17473915
*	Date:		2016-06-06 03:18:38
*	Runtime:	1.730
*	Ranking:	3852 / 4636
*/
public class Main10067 {


	/**
	 * - Dijkstra
	 * - Priority Queue
	 * - Simulaci�n
	 * 
	 * Dadas 4 ruedas con n�meros del 0 al 9, una configuraci�n inicial, un target y
	 * unas posiciones prohibidas
	 * establecer la m�nima cantidad de movimientos necesarios para llegar al target
	 */
	public static void main(String[] args) {
		
		Grafo10067 grafo = new Grafo10067();
		grafo.createNodes(10000);
		
		for (int x = 0; x < 10000; x++) {
			String v = "000" + x;
			v = v.substring(v.length() - 4, v.length());
		//	System.out.println(v);
			for (int i = 0; i < v.length(); i++) {
				char[] c = v.toCharArray();
				c[i] = c[i] > '0' ? (char) (c[i] - 1) : '9';
				grafo.addAdyacente(x, getValue(c), 1);
				// System.out.println(Arrays.toString(c));

				c = v.toCharArray();
				c[i] = c[i] < '9' ? (char) (c[i] + 1) : '0';
				grafo.addAdyacente(x, getValue(c), 1);
				// System.out.println(Arrays.toString(c));
			}
		}
		
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		input.nextLine();
		for (int i = 0; i < testCases; i++) {
			int origen = input.nextInt() *1000 + input.nextInt()*100 + input.nextInt()*10 + input.nextInt();
			int destino = input.nextInt() *1000 + input.nextInt()*100 + input.nextInt()*10 + input.nextInt();
			int prohibidos = input.nextInt();
			
			int forbiddens[] = new int[prohibidos];
			for (int x = 0; x < prohibidos; x++) {
				forbiddens[x] = input.nextInt() *1000 + input.nextInt()*100 + input.nextInt()*10 + input.nextInt();
				grafo.nodosExistentes.get(forbiddens[x]).setAvailable(false);
			}

			List<Arista10067> aristas = grafo.getInicial(origen).getAristas();

			boolean visited[] = new boolean[10000];
			visited[origen] = true;
			int distances[] = new int[10000];
//			for (int x = 0; x < 10000; x++) {
//				distances[x] = -1;
//			}
			
			if (origen == destino) {
				System.out.println(0);
				continue;
			}
			PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();

			for (Arista10067 arista : aristas) {
				if (arista.getNodoDestino().isAvailable()) {
					priorityQueue.add(new Item(arista.getNodoDestino()
							.getValue(), arista.getPeso()));
				}

				if (arista.getNodoOrigen().isAvailable()) {
					priorityQueue.add(new Item(arista.getNodoOrigen()
							.getValue(), arista.getPeso()));
				}
			}

			while (priorityQueue.size() > 0) {
				Item item = priorityQueue.poll();
				if (!visited[item.getRow()]) {
					visited[item.getRow()] = true;
					distances[item.getRow()] = item.getDistance();
					aristas = grafo.getInicial(item.getRow()).getAristas();

					for (Arista10067 arista : aristas) {
						if (!visited[arista.getNodoOrigen().getValue()]
								&& arista.getNodoOrigen().isAvailable()) {
							priorityQueue.add(new Item(arista.getNodoOrigen()
									.getValue(), item.getDistance()
									+ arista.getPeso()));

						}
						if (!visited[arista.getNodoDestino().getValue()]
								&& arista.getNodoDestino().isAvailable()) {
							priorityQueue.add(new Item(arista.getNodoDestino()
									.getValue(), item.getDistance()
									+ arista.getPeso()));

						}

					}
				}
			}
			if (distances[destino] == 0) {
				System.out.println("-1");
			} else {
				System.out.println( distances[destino]);
			}
			grafo.clean(forbiddens);
		}
		input.close();
	}

	private static int getValue(char[] c) {
		int value = 0, mult =1000;
		for (int i = 0 ; i < 4; i++) {
			value += (c[i] -48) *mult;
			mult /=10;
		}
		return value;
	}

}

class Grafo10067 {

	int max = Integer.MAX_VALUE;
	int friendship;
	public int nodoFinal;
	Map<Integer, Nodo10067> nodosExistentes = new HashMap<Integer, Nodo10067>();

	public void createNodes(int qty) {

		for (int i = 0; i < qty; i++) {
			nodosExistentes.put(i, crearNodo(i));
		}

		max = Integer.MAX_VALUE;
	}

	public void clean(int[] forbiddens) {
		for (int i = 0; i < 10000; i++) {
			nodosExistentes.get(i).setRecorrido(max);
		}

		for (int value : forbiddens) {
			nodosExistentes.get(value).setAvailable(true);
		}
	}

	public Nodo10067 getInicial(int origen) {
		return nodosExistentes.get(origen);
	}

	public void addAdyacente(int origen, int destino, int peso) {

		Nodo10067 nodoOrigen = nodosExistentes.get(origen);
		Nodo10067 nodoDestino = nodosExistentes.get(destino);

		Arista10067 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);
		//nodoDestino.getAristas().add(arista);
	}

	private Arista10067 crearArista(Nodo10067 nodoOrigen,
			Nodo10067 nodoDestino, int peso) {
		Arista10067 arista = new Arista10067();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		arista.setValida(true);

		return arista;
	}

	private Nodo10067 crearNodo(int value) {
		Nodo10067 nodo = new Nodo10067();
		nodo.setValue(value);
		nodo.setRecorrido(max);
		nodo.setAristas(new ArrayList<Arista10067>());
		nodo.setAvailable(true);
		return nodo;
	}

}

class Arista10067 {
	private Nodo10067 nodoOrigen;
	private Nodo10067 nodoDestino;
	private int peso;
	private boolean valida;
	private int linea;

	@Override
	public String toString() {
		return "origen = " + nodoOrigen.getValue() + " ; destino = "
				+ nodoDestino.getValue() + " ; peso = " + peso + " ; linea = "
				+ linea;
	}

	public Nodo10067 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo10067 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo10067 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo10067 nodoDestino) {
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

class Nodo10067 {

	private int value;
	private List<Arista10067> aristas;
	private int recorrido;
	private boolean visitado;
	private boolean available;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Arista10067> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista10067> aristas) {
		this.aristas = aristas;
	}

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
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
