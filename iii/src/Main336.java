import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * 336 - A Node Too Far
 * 
 * - Grafos, Búsqueda en profundidad - Grafos dirigidos - Queue - En una red de
 * computadores, y dado un TTL, mostrar cuantos equipos no son alcanzables,
 * desde un origen dado
 * 
 * @author fabio
 *
 */

/**
*	336 - A Node Too Far
*
*
*	Submision:	16945929
*	Date:		2016-03-04 02:06:39
*	Runtime:	0.859
*	Ranking:	4385
*/
public class Main336 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int conexiones;
		int cases = 0;
		while ((conexiones = input.nextInt()) != 0) {
			Grafo grafo = new Grafo();
			int a, b;

			for (int i = 0; i < conexiones; i++) {
				a = input.nextInt();
				b = input.nextInt();
				grafo.addAdyacente(a, b);
			}
			int origen = input.nextInt();
			int ttl = input.nextInt();

			while (origen != 0 || ttl != 0) {
				cases++;
				System.out
						.printf("Case %d: %d nodes not reachable from node %d with TTL = %d.\n",
								cases, grafo.solve(origen, ttl), origen, ttl);
				origen = input.nextInt();
				ttl = input.nextInt();

			}
		}
		input.close();
	}
}

class Grafo {

	List<Nodo> nodos = new ArrayList<Nodo>();
	Map<Integer, Nodo> mapNodos = new HashMap<Integer, Nodo>();

	public void createNodes(int qty) {
		nodos = new ArrayList<Nodo>();
		for (int i = 0; i < qty; i++) {
			Nodo nodo = new Nodo();

			nodo.setValue(i);
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
		}

	}

	public void addAdyacente(int origen, int destino) {
		Nodo nodoOrigen = getNodo(origen);
		Nodo nodoDestino = getNodo(destino);
		nodoOrigen.getAdyacentes().add(nodoDestino);
		nodoDestino.getAdyacentes().add(nodoOrigen);
	}

	private Nodo getNodo(int value) {

		Nodo nodo = mapNodos.get(value);
		if (nodo == null) {
			nodo = new Nodo();
			nodo.setValue(value);
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
			mapNodos.put(value, nodo);
		}
		return nodo;
	}

	public int solve(int source, int ttl) {

		clear();
		Nodo nodoOrigen = mapNodos.get(source);

		if (nodoOrigen == null) {
			return nodos.size();
		}
		nodoOrigen.setVisitado(true);

		// buscamos los adyacentes
		Queue<Nodo> queue = new LinkedList<Nodo>();
		int visitados = 1;
		nodoOrigen.setDia(0);
		queue.add(nodoOrigen);
		while (!queue.isEmpty()) {
			Nodo nodo2 = queue.poll();

			for (Nodo nodo : nodo2.getAdyacentes()) {
				if (!nodo.isVisitado()) {
					if ((nodo2.getDia() + 1) <= ttl) {
						nodo.setVisitado(true);
						nodo.setDia(nodo2.getDia() + 1);
						queue.add(nodo);
						visitados++;
					}
				}
			}
		}

		return nodos.size() - visitados;
	}

	/*
	 * 16 10 15 15 20 20 25 10 30 30 47 47 50 25 45 45 65 15 35 35 55 20 40 50
	 * 55 35 40 55 60 40 60 60 65 14 1 2 2 7 1 3 3 4 3 5 5 10 5 11 4 6 7 6 7 8 7
	 * 9 8 9 8 6 6 11
	 */
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
