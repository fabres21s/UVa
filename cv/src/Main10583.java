import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
*	10583 - 	Ubiquitous Religions
*	Submission:	18649446
*	Date:		2017-01-19 19:03:06
*	Runtime:	1.040
*	Ranking:	4695 / 5470
*/
public class Main10583 {

	/**
	 * - Grafos bidireccionales
	 * - Búsqueda en profundidad
	 * - Queue
	 * 
	 * Encontrar cuántos subgrafos hay en un grafo
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int persons, groups;
		int testCases = 0;
		while (true) {
			testCases++;
			persons = input.nextInt();
			groups = input.nextInt();

			if (persons == 0 && groups == 0) {
				break;
			}

			Grafo grafo = new Grafo();
			grafo.createNodes(persons);

			int origen, destino;
			for (int i = 0; i < groups; i++) {
				destino = input.nextInt();

				origen = input.nextInt();
				grafo.addAdyacente(origen, destino);

			}

			System.out.println("Case "+testCases+": "+grafo.solve());
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

	public int solve() {

		// buscamos los adyacentes
		int religions = -1; //el 0 nunca va  a ser utilizado

		Queue<Nodo> queue = new LinkedList<Nodo>();

		for (Nodo n : nodos) {

			if (!n.isVisitado()) {
				religions++;
				queue.add(n);
				while (!queue.isEmpty()) {
					Nodo nodo2 = queue.poll();

					for (Nodo nodo : nodo2.getAdyacentes()) {
						if (!nodo.isVisitado()) {
							nodo.setVisitado(true);
							queue.add(nodo);
						}
					}
				}
			}
		}

		return (religions);
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
