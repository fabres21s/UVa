import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
*	1197 - The Suspects
*
*
*	Submision:	17196971
*	Date:		2016-04-13 17:26:45
*	Runtime:	0.250
*	Ranking:	609
*/
public class Main1197 {

	/**
	 * - Grafos bidireccionales
	 * - Búsqueda en profundidad
	 * - Queue
	 * 
	 * Encontrar cuantos nodos están conectados al nodo 0
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int persons, groups;

		while (true) {
			persons = input.nextInt();
			groups = input.nextInt();

			if (persons == 0 && groups == 0) {
				break;
			}

			Grafo grafo = new Grafo();
			grafo.createNodes(persons + 2);

			int origen, destino, miembros;
			for (int i = 0; i < groups; i++) {
				miembros = input.nextInt();

				origen = input.nextInt();

				for (int j = 1; j < miembros; j++) {
					destino = input.nextInt();

					grafo.addAdyacente(origen, destino);
					origen = destino;
				}
			}

			grafo.solve(0);
		}

		input.close();
	}
}

class Grafo {

	List<Nodo> nodos;
	int max;
	int friendship;

	public void createNodes(int qty) {
		nodos = new ArrayList<Nodo>();
		for (int i = 0; i <= qty; i++) {
			Nodo nodo = new Nodo();

			nodo.setValue(i);
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
		}
		max = 0;
	}

	public void addAdyacente(int origen, int destino) {
		Nodo nodoOrigen = nodos.get(origen);
		Nodo nodoDestino = nodos.get(destino);
		nodoOrigen.getAdyacentes().add(nodoDestino);
		// como es bidireccional
		nodoDestino.getAdyacentes().add(nodoOrigen);
	}

	public void solve(int source) {

		Nodo nodoOrigen = nodos.get(source);

		nodoOrigen.setVisitado(true);

		// buscamos los adyacentes
		int friends = 1;
		Queue<Nodo> queue = new LinkedList<Nodo>();

		nodoOrigen.setDia(0);
		queue.add(nodoOrigen);
		while (!queue.isEmpty()) {
			Nodo nodo2 = queue.poll();

			for (Nodo nodo : nodo2.getAdyacentes()) {
				if (!nodo.isVisitado()) {
					friends++;
					nodo.setVisitado(true);
					queue.add(nodo);
				}
			}
		}

		System.out.println(friends);
	}

	private void print() {
		for (Nodo nodo : nodos) {
			System.out.println(nodo);
		}
	}

	public void clear() {
		for (Nodo nodo : nodos) {
			nodo.setVisitado(false);
		}
	}

}

class Nodo {

	private int value;
	private List<Nodo> adyacentes;
	private boolean visitado;
	private int dia;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public List<Nodo> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(List<Nodo> adyacentes) {
		this.adyacentes = adyacentes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return value + " -  " + dia + " -  " + visitado;
	}

}
/*
 * 
 * 6
 * 
 * 10 12 1 2 3 1 3 4 5 4 3 5 4 6 5 2 2 1 7 10 1 2 9 10 8 9
 * 
 * 3 5 1 2 2 3 1 1 2 2 3 3
 * 
 * 10 9 1 2 2 3 3 3 1 1 2 1 4 5 5 7 3 4 7 5
 * 
 * 200 16 1 2 2 3 3 4 5 66 66 7 7 8 4 66 99 10 24 25 62 65 66 66 24 99 10 62 11
 * 12 10 11 200 199
 * 
 * 1 1 1 1
 * 
 * 100 9 99 10 24 25 62 65 66 66 24 99 10 62 11 12 10 11 100 62
 */
