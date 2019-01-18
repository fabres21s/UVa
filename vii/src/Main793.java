import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main793 {

	//TODO - Poner información
	//Como el 336 - pero también pueden ser usados disjoin sets
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		br.readLine();
		String line;
		StringBuffer output = new StringBuffer();
		while (testCases-- > 0) {
			Grafo grafo = new Grafo();
			grafo.createNodes(Integer.parseInt(br.readLine()) + 1);
			int origin, target, success = 0, unsuccess = 0;
			while ((line = br.readLine()) != null) {

				if (line.isEmpty()) {
					break;
				}
				args = line.split(" ");
				origin = Integer.parseInt(args[1]);
				target = Integer.parseInt(args[2]);
				switch (args[0]) {
				case "c":
					grafo.addAdyacente(origin, target);
					break;

				case "q":

					if (grafo.solve(origin, target)) {
						success++;
					} else {
						unsuccess++;
					}

					break;
				}

			}
			output.append(String.format("%d,%d\n", success, unsuccess));
			if (testCases > 0) {
				output.append("\n");
			}

		}
		System.out.print(output);
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
			mapNodos.put(i, nodo);
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

	public boolean solve(int source, int target) {

		clear();
		Nodo nodoOrigen = mapNodos.get(source);

		if (nodoOrigen.getValue() == target) {
			return true;
		}
		nodoOrigen.setVisitado(true);

		// buscamos los adyacentes
		Queue<Nodo> queue = new LinkedList<Nodo>();

		queue.add(nodoOrigen);
		while (!queue.isEmpty()) {
			Nodo nodo2 = queue.poll();

			for (Nodo nodo : nodo2.getAdyacentes()) {
				if (nodo.getValue() == target) {
					return true;
				}

				if (!nodo.isVisitado()) {
					nodo.setVisitado(true);
					queue.add(nodo);
				}
			}
		}

		return false;
	}

	/*
	 * 16 10 15 15 20 20 25 10 30 30 47 47 50 25 45 45 65 15 35 35 55 20 40 50 55 35
	 * 40 55 60 40 60 60 65 14 1 2 2 7 1 3 3 4 3 5 5 10 5 11 4 6 7 6 7 8 7 9 8 9 8 6
	 * 6 11
	 */

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

	@Override
	public String toString() {
		return value + " -  " + visitado;
	}

}
