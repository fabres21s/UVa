import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
*	1112 - Mice and Maze
*
*	Submission:	25159951
*	Date:		2020-06-21 00:00:47
*	Runtime:	0.120
*	Ranking:	2575 / 2731
*/
public class Main1112 {

	/**
	 * - Grafos
	 * - Dijkstra
	 * - Priority Queue
	 * 
	 * Similar al 10986
	 * 
	 * A partir de un nodo, encontrar cuántos nodos son alcanzables en un tiempo menor o igual a T
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		StringBuffer output = new StringBuffer();
		
		int testCases = input.nextInt();
		int mices, conexiones, origen, time;
		for (int i = 1; i <= testCases; i++) {

			Grafo grafo = new Grafo();

			mices = input.nextInt();
			grafo.createNodes(mices);

			origen = (input.nextInt());

			time = input.nextInt();

			conexiones = input.nextInt();

			for (int j = 0; j < conexiones; j++) {
				grafo.addAdyacente(input.nextInt(), input.nextInt(), input.nextInt());
			}
			List<Arista> aristas = grafo.nodosExistentes.get(origen).getAristas();

			boolean visited[] = new boolean[mices + 1];
			visited[origen] = true;
			int distances[] = new int[mices + 1];
			Arrays.fill(distances, time +1);
			distances[origen] = 0;

			PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();

			for (Arista arista : aristas) {
				priorityQueue.add(new Item(arista.getNodoDestino().getValue(), arista.getPeso()));
			}

			while (priorityQueue.size() > 0) {
				Item item = priorityQueue.poll();
				if (!visited[item.getRow()]) {
					visited[item.getRow()] = true;
					distances[item.getRow()] = item.getDistance();
					aristas = grafo.nodosExistentes.get(item.getRow()).getAristas();

					for (Arista arista : aristas) {
						if (!visited[arista.getNodoDestino().getValue()]) {
							priorityQueue.add(new Item(arista.getNodoDestino().getValue(),
									item.getDistance() + arista.getPeso()));

						}

					}
				}
			}
			int count = 0;
			for (int x =1; x <= mices; x++) {
				if (distances[x] <= time)  {
					count++;
				}
			}
			output.append(count);
			output.append("\n");
			if (i < testCases) {
				output.append("\n");
			}
			
		}
		System.out.print(output);
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

	Map<Integer, Nodo> nodosExistentes;

	public void createNodes(int qty) {

		nodosExistentes = new HashMap<Integer, Nodo>();

		for (int i = 1; i <= qty; i++) {
			nodosExistentes.put(i, crearNodo(i));
		}
	}

	public void addAdyacente(int origen, int destino, int peso) {

		Nodo nodoOrigen = nodosExistentes.get(origen);

		Nodo nodoDestino = nodosExistentes.get(destino);

		Arista arista = crearArista(nodoDestino, nodoOrigen, peso);
		nodoDestino.getAristas().add(arista);
		nodosExistentes.put(destino, nodoDestino);

	}

	private Arista crearArista(Nodo nodoOrigen, Nodo nodoDestino, int peso) {
		Arista arista = new Arista();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);

		return arista;
	}

	private Nodo crearNodo(int value) {
		Nodo nodo = new Nodo();
		nodo.setValue(value);
		nodo.setAristas(new ArrayList<Arista>());
		return nodo;
	}

}

class Arista {
	private Nodo nodoOrigen;
	private Nodo nodoDestino;
	private int peso;

	@Override
	public String toString() {
		return "origen = " + nodoOrigen.getValue() + " ; destino = " + nodoDestino.getValue() + " ; peso = " + peso;
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

}

class Nodo {

	private int value;
	private List<Arista> aristas;

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

}
