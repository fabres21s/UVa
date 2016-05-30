import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 280 - Vertex
 * 
 * - Grafos, Búsqueda en profundidad - Grafos bidireccionales - Queue
 * 
 * Encontrar cuantos y cuáles nodos no están conectados a un nodo dado
 * 
 * @author fabio
 *
 */
/**
*	280 - Vertex
*
*
*	Submision:	17198476
*	Date:		2016-04-14 02:38:50
*	Runtime:	1.150
*	Ranking:	2143
*/
public class Main280 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int vertex;
		while ((vertex = input.nextInt()) != 0) {

			Grafo grafo = new Grafo();

			grafo.createNodes(vertex);

			int origen, destino;

			while ((origen = input.nextInt()) != 0) {
				while ((destino = input.nextInt()) != 0) {
					grafo.addAdyacente(origen, destino);
				}
			}

			int casos = input.nextInt();

			for (int i = 0; i < casos; i++) {
				grafo.solve(input.nextInt());
				grafo.clear();
			}
		}

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

	}

	public void solve(int source) {

		Nodo nodoOrigen = nodos.get(source);

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

		StringBuffer output = new StringBuffer();
		output.append((nodos.size() - friends) + " ");
		for (int i = 1; i < nodos.size(); i++) {
			if (!nodos.get(i).isVisitado()) {
				output.append(i + " ");
			}
		}
		System.out.println(output.toString().trim());
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
