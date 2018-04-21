import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
*	924 - Spreading The News
*
*
*	Submission:	16546925
*	Date:		2015-12-06 19:03:26
*	Runtime:	0.382
*	Ranking:	1644
*/
public class Main924 {

	/**
	 * - B�squeda en profundidad
	 * - Grafos dirigidos
	 * - Queue
	 * 
	 * Dado un grafo
	 * dirigido, tomar un nodo como principal, hacer una b�squeda en profundidad
	 * hallar en qu� nivel se encuentran la mayor cantidad de nodos y cuantos nodos
	 * hay
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int employees = input.nextInt();
		Grafo grafo = new Grafo();
		grafo.createNodes(employees);
		for (int i = 0; i < employees; i++) {
			int n = input.nextInt();
			for (int j = 0; j < n; j++) {
				grafo.addAdyacente(i, input.nextInt());
			}
		}

		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			grafo.solve(input.nextInt());
		}

		input.close();
	}
}

class Grafo {

	List<Nodo> nodos;
	int arreglo[];

	public void createNodes(int qty) {
		nodos = new ArrayList<Nodo>();
		for (int i = 0; i < qty; i++) {
			Nodo nodo = new Nodo();

			nodo.setValue(i);
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
		}
		arreglo = new int[qty];

	}

	public void addAdyacente(int origen, int destino) {
		Nodo nodoOrigen = nodos.get(origen);
		Nodo nodoDestino = nodos.get(destino);
		nodoOrigen.getAdyacentes().add(nodoDestino);
	}

	public void solve(int source) {

		clear();
		Nodo nodoOrigen = nodos.get(source);
		nodoOrigen.setVisitado(true);

		// buscamos los adyacentes
		Queue<Nodo> queue = new LinkedList<Nodo>();

		nodoOrigen.setDia(0);
		queue.add(nodoOrigen);
		while (!queue.isEmpty()) {
			Nodo nodo2 = queue.poll();

			for (Nodo nodo : nodo2.getAdyacentes()) {
				if (!nodo.isVisitado()) {
					nodo.setVisitado(true);
					nodo.setDia(nodo2.getDia() + 1);
					arreglo[nodo.getDia()]++;
					queue.add(nodo);
				}
			}
		}

		int max = 0, posMax = 0;
		for (int i = 1; i < nodos.size(); i++) {
			if (arreglo[i] > max) {
				max = arreglo[i];
				posMax = i;
			}
		}
		if (max > 0) {
			System.out.println(max + " " + posMax);
		} else
			System.out.println(0);
		// print();

	}

	public void clear() {
		for (Nodo nodo : nodos) {
			nodo.setVisitado(false);
		}
		arreglo = new int[nodos.size()];
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
