import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
*	10305 - Ordering Tasks
*
*
*	Submission:	16881285
*	Date:		2016-02-21 14:23:28
*	Runtime:	0.078
*	Ranking:	7278
*/
public class Main10305 {

	/**
	 * - Ordenaci�n topol�gica
	 * - Grafos dirigidos
	 * - Stack
	 * 
	 * Encontrar el orden de ejecuci�n de unas tareas, unas dependen den otras
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int tasks = input.nextInt();
			int precedences = input.nextInt();
			if (tasks == precedences && precedences == 0) {
				break;
			}

			Grafo grafo = new Grafo();
			grafo.createNodes(tasks);

			for (int i = 0; i < precedences; i++) {
				grafo.addAdyacente(input.nextInt(), input.nextInt());
			}

			grafo.topologicalSort();
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
		for (int i = 1; i <= qty; i++) {
			Nodo nodo = new Nodo();

			nodo.setValue(i);
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
		}
		max = 0;
	}

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		for (Nodo nodo : nodos) {
			if (!nodo.isVisitado()) {
				topologicalSortUtil(nodo, stack);
			}
		}

		StringBuffer output = new StringBuffer();
		while (!stack.isEmpty()) {
			output.append(stack.pop() + " ");
		}

		System.out.println(output.toString().trim());
	}

	private void topologicalSortUtil(Nodo nodoOrigen, Stack<Integer> stack) {
		nodoOrigen.setVisitado(true);
		for (Nodo nodo : nodoOrigen.getAdyacentes()) {
			if (!nodo.isVisitado()) {
				topologicalSortUtil(nodo, stack);
			}
		}

		stack.push(nodoOrigen.getValue());
	}

	public void addAdyacente(int origen, int destino) {
		Nodo nodoOrigen = nodos.get(origen - 1);
		Nodo nodoDestino = nodos.get(destino - 1);
		nodoOrigen.getAdyacentes().add(nodoDestino);
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
