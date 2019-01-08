import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main10048 {

	public static int MAX = Integer.MAX_VALUE;

	//TODO - POner información - similar 544 y 10099
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		String line;
		String city1, city2;
		int audio;
		int cities, roads, queries;
		int cases = 0;
		while (!(line = br.readLine()).equals("0 0 0")) {
			cases++;

			if (cases > 1) {
				output.append("\n");
			}

			args = line.split(" ");

			cities = Integer.parseInt(args[0]);
			roads = Integer.parseInt(args[1]);
			queries = Integer.parseInt(args[2]);

			Grafo10048 grafo = new Grafo10048();
			grafo.createNodes();
			for (int i = 0; i < roads; i++) {
				args = br.readLine().split(" ");
				city1 = args[0];
				city2 = args[1];
				audio = Integer.parseInt(args[2]);

				grafo.addAdyacente(city1, city2, audio);
			}

			output.append(String.format("Case #%d\n", cases));
			for (int i = 0; i < queries; i++) {
				args = br.readLine().split(" ");
				city1 = args[0];
				city2 = args[1];

				grafo.solve(grafo.getNodo(city1));

				Nodo10048 nodo = grafo.getNodo(city2);
				if (nodo != null) {
					audio = nodo.getMaxSound();
				} else {
					audio = 0;
				}

				grafo.unvisited();

				if (audio > 0) {
					output.append(String.format("%d\n", audio));
				} else {
					output.append("no path\n");
				}
			}

		}
		System.out.print(output);

	}
}

class Grafo10048 {

	int max = Integer.MAX_VALUE;
	private List<Nodo10048> nodosEtiquetados;
	private List<Nodo10048> nodos;
	public String nodoFinal;
	Map<String, List<Nodo10048>> nodosExistentes;

	public void createNodes() {

		nodosEtiquetados = new ArrayList<Nodo10048>();
		nodos = new ArrayList<Nodo10048>();
		nodosExistentes = new HashMap<String, List<Nodo10048>>();
		max = Integer.MAX_VALUE;
	}

	public void unvisited() {
		for (Nodo10048 nodo : nodos) {
			nodo.setVisitado(false);
			nodo.setMaxSound(0);
		}

	}

	public Nodo10048 getNodo(String origen) {

		if (nodosExistentes.get(origen) == null) {
			return null;
		}
		return nodosExistentes.get(origen).get(0);

	}

	public void addAdyacente(String origen, String destino, int peso) {

		Nodo10048 nodoOrigen = null;

		List<Nodo10048> nodos = nodosExistentes.get(origen);

		if (nodos == null) {
			nodoOrigen = crearNodo(origen);
			nodos = new ArrayList<Nodo10048>();
			nodos.add(nodoOrigen);
		} else {
			nodoOrigen = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista

		}
		nodosExistentes.put(origen, nodos);

		Nodo10048 nodoDestino = null;

		nodos = nodosExistentes.get(destino);

		if (nodos == null) {
			nodos = new ArrayList<Nodo10048>();
			nodoDestino = crearNodo(destino);
			nodos.add(nodoDestino);
		} else {
			nodoDestino = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista

		}

		nodosExistentes.put(destino, nodos);
		Arista10048 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);
		nodoDestino.getAristas().add(arista);

	}

	private Arista10048 crearArista(Nodo10048 nodoOrigen, Nodo10048 nodoDestino, int peso) {
		Arista10048 arista = new Arista10048();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		return arista;
	}

	private Nodo10048 crearNodo(String value) {
		Nodo10048 nodo = new Nodo10048();
		nodo.setValue(value);
		nodo.setMaxSound(0);
		nodo.setAristas(new ArrayList<Arista10048>());
		nodos.add(nodo);
		return nodo;
	}

	public void solve(Nodo10048 nodo) {

		if (nodo != null) {

			nodosEtiquetados.remove(nodo);
			nodo.setVisitado(true);

			int max = Integer.MAX_VALUE;
			Nodo10048 siguiente = new Nodo10048();
			for (Arista10048 arista : nodo.getAristas()) {

				Nodo10048 nodoDestino = arista.getNodoDestino();

				if (!nodoDestino.isVisitado()) {

					nodosEtiquetados.remove(nodoDestino);
					nodoDestino.setMaxSound(Math.max(nodo.getMaxSound(), arista.getPeso()));

					nodosEtiquetados.add(nodoDestino);
				}
				// por ser bidireccionales
				nodoDestino = arista.getNodoOrigen();

				if (!nodoDestino.isVisitado()) {
					nodosEtiquetados.remove(nodoDestino);

					nodoDestino.setMaxSound(Math.max(nodo.getMaxSound(), arista.getPeso()));

					nodosEtiquetados.add(nodoDestino);
				}
			}

			for (Nodo10048 nodoEtiquetado : nodosEtiquetados) {
				if (nodoEtiquetado.getMaxSound() < max) {

					max = nodoEtiquetado.getMaxSound();
					siguiente = nodoEtiquetado;
				}
			}

			if (nodosEtiquetados.size() > 0) {

				nodosEtiquetados.remove(siguiente);

				solve(siguiente);

			}
		}
	}
}

class Arista10048 {
	private Nodo10048 nodoOrigen;
	private Nodo10048 nodoDestino;
	private int peso;

	public Nodo10048 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo10048 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo10048 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo10048 nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
}

class Nodo10048 {

	private String value;
	private List<Arista10048> aristas;
	private boolean visitado;
	private int maxSound = 0;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Arista10048> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista10048> aristas) {
		this.aristas = aristas;
	}

	@Override
	public String toString() {
		return "nodo = " + value + "; maxSound = " + maxSound;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getMaxSound() {
		return maxSound;
	}

	public void setMaxSound(int maxSound) {
		if (maxSound < this.maxSound || this.maxSound == 0) {
			this.maxSound = maxSound;
		}
	}

}
