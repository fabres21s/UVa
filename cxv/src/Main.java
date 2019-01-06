import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int friendship;
		int testCases = Integer.parseInt(br.readLine());
		Grafo grafo = new Grafo();
		while (testCases-- > 0) {
			friendship = Integer.parseInt(br.readLine());

			for (int i = 0; i < friendship; i++) {
				args = br.readLine().split(" ");
				grafo.addAdyacente(args[0], args[1]);
				grafo.solve();
			}

			grafo.setNodos(new HashMap<>());
		}
		System.out.print(grafo.getOutput());

	}
}

class Grafo {

	Map<String, Nodo> nodos = new HashMap<String, Nodo>();
	String firstName;
	StringBuffer output = new StringBuffer();

	public Nodo getNodo(String name) {
		if (nodos.get(name) == null) {
			Nodo nodo = new Nodo();

			nodo.setName(name);
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.put(name, nodo);

			return nodo;
		}

		return nodos.get(name);
	}

	public void addAdyacente(String name1, String name2) {
		firstName = name1;
		Nodo nodoOrigen = getNodo(name1);
		Nodo nodoDestino = getNodo(name2);
		nodoOrigen.getAdyacentes().add(nodoDestino);
		// como es bidireccional
		nodoDestino.getAdyacentes().add(nodoOrigen);
	}

	public void solve() {

		Nodo nodoOrigen = nodos.get(firstName);

		nodoOrigen.setVisitado(true);

		// buscamos los adyacentes
		int friends = 1;
		Queue<Nodo> queue = new LinkedList<Nodo>();

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

		output.append(String.format("%d\n", friends));
		clear();
	}

	private void clear() {
		for (Map.Entry<String, Nodo> entry : nodos.entrySet()) {
			entry.getValue().setVisitado(false);
		}
	}

	public void setNodos(Map<String, Nodo> nodos) {
		this.nodos = nodos;
	}

	public StringBuffer getOutput() {
		return output;
	}

	public void setOutput(StringBuffer output) {
		this.output = output;
	}

}

class Nodo {

	private String name;

	private List<Nodo> adyacentes;
	private boolean visitado;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " -  " + visitado;
	}

}
