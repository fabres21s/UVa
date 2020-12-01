import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
*	10801 - Lift Hopping
*
*
*	Submission:	16889535
*	Date:		2016-02-23 03:21:05
*	Runtime:	0.092
*	Ranking:	2865 / 3188
*/
public class Main10801 {

	public static int MAX = Integer.MAX_VALUE;

	/**
	 * - Grafos bidireccionales
	 * - Dijkstra
	 * - Map
	 * - List
	 * - Recursividad
	 * 
	 * Dados n ascensores, un piso objetivo y la velocidad de ascenso/descenso por
	 * piso de cada uno de los ascensores por piso y los pisos en los que para cada
	 * ascensor Encontrar el menor tiempo para ir desde el piso 0 hasta el objetivo
	 * 
	 * Uno de los m�s completos que he hecho
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			args = input.nextLine().split(" ");
			int ascensores = Integer.valueOf(args[0]);
			Grafo grafo = new Grafo();
			grafo.nodoFinal = Integer.valueOf(args[1]);
			int qty = 100;

			grafo.createNodes(qty);

			int tiempos[] = new int[ascensores];
			args = input.nextLine().split(" ");
			for (int i = 0; i < ascensores; i++) {
				tiempos[i] = Integer.valueOf(args[i]);
			}

			for (int i = 0; i < ascensores; i++) {
				args = input.nextLine().split(" ");

				for (int j = 1; j < args.length; j++) {
					int origen = Integer.valueOf(args[j - 1]);
					int destino = Integer.valueOf(args[j]);
					grafo.addAdyacente(origen, destino, (destino - origen)
							* tiempos[i], i + 1);
				}
			}
			Nodo nodoinicial = grafo.get0();
			if (nodoinicial != null) {
				grafo.solve(grafo.get0(), 0);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
		input.close();
	}
}

class Grafo {

	int max = Integer.MAX_VALUE;
	int friendship;
	private List<Nodo> nodosEtiquetados;
	public int nodoFinal;
	Map<Integer, List<Nodo>> nodosExistentes;

	public void createNodes(int qty) {

		nodosEtiquetados = new ArrayList<Nodo>();
		nodosExistentes = new HashMap<Integer, List<Nodo>>();
		max = Integer.MAX_VALUE;
	}

	public Nodo get0() {
		List<Nodo> nodos = nodosExistentes.get(0);
		if (nodos != null) {
			for (Nodo nodo : nodos) {
				nodo.setRecorrido(0);
				nodosEtiquetados.add(nodo);
			}

			return nodos.get(0);
		}
		return null;
	}

	public void addAdyacente(int origen, int destino, int peso, int linea) {

		Nodo nodoOrigen = null;

		List<Nodo> nodos = nodosExistentes.get(origen);

		if (nodos == null) {
			nodoOrigen = crearNodo(origen, linea);
			nodos = new ArrayList<Nodo>();
			nodos.add(nodoOrigen);
		} else {
			nodoOrigen = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista
			if (linea != nodoOrigen.getLinea()) {
				nodoOrigen = crearNodo(origen, linea);
				nodos.add(nodoOrigen);
				for (int i = 0; i < nodos.size() - 1; i++) {
					Nodo nodoIgual = nodos.get(i);
					Arista arista = crearArista(nodoOrigen, nodoIgual, 60,
							linea);
					nodoOrigen.getAristas().add(arista);
					nodoIgual.getAristas().add(arista);
				}
				// con todos los existentes poner un peso de 0
			} else {
			}
		}
		nodosExistentes.put(origen, nodos);

		Nodo nodoDestino = null;

		nodos = nodosExistentes.get(destino);

		if (nodos == null) {
			nodos = new ArrayList<Nodo>();
			nodoDestino = crearNodo(destino, linea);
			nodos.add(nodoDestino);
		} else {
			nodoDestino = nodos.get(nodos.size() - 1); // traemos el �ltimo nodo
														// de las lista
			if (linea != nodoDestino.getLinea()) {
				nodoDestino = crearNodo(destino, linea);
				nodos.add(nodoDestino);
				for (int i = 0; i < nodos.size() - 1; i++) {
					Nodo nodoIgual = nodos.get(i);
					Arista arista = crearArista(nodoDestino, nodoIgual, 60,
							linea);
					nodoDestino.getAristas().add(arista);
					nodoIgual.getAristas().add(arista);
				}
				// con todos los existentes poner un peso de 0
			} else {
			}
		}

		nodosExistentes.put(destino, nodos);
		Arista arista = crearArista(nodoOrigen, nodoDestino, peso, linea);
		nodoOrigen.getAristas().add(arista);
		nodoDestino.getAristas().add(arista);

	}

	private Arista crearArista(Nodo nodoOrigen, Nodo nodoDestino, int peso,
			int linea) {
		Arista arista = new Arista();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		arista.setValida(true);
		arista.setLinea(linea);

		return arista;
	}

	private Nodo crearNodo(int value, int linea) {
		Nodo nodo = new Nodo();
		nodo.setLinea(linea);
		nodo.setValue(value);
		nodo.setRecorrido(max);
		nodo.setAristas(new ArrayList<Arista>());
		return nodo;
	}

	public void solve(Nodo nodo, int recorridoPrevio) {

		nodosEtiquetados.remove(nodo);
		nodo.setVisitado(true);

		// 0 20 2000 3
		// 0 20 1000 2
		// 0 10 100 1
		// 10 30 200 1
		// 30 40 100 1
		// 20 30 500 2
		// 20 50 3000 3

		int min = Integer.MAX_VALUE;
		Nodo siguiente = new Nodo();
		for (Arista arista : nodo.getAristas()) {

			Nodo nodoDestino = arista.getNodoDestino();
			int cambioLinea = 0;
			if (arista.getLinea() != nodo.getLinea() && nodo.getLinea() > 0) {
				// cambioLinea = 60;
			}
			if (!nodoDestino.isVisitado()) {

				if (arista.getPeso() + recorridoPrevio + cambioLinea < nodoDestino
						.getRecorrido()) {
					nodosEtiquetados.remove(nodoDestino);
					nodoDestino.setRecorrido(arista.getPeso() + recorridoPrevio
							+ cambioLinea);
					nodoDestino.setLinea(arista.getLinea());
					nodosEtiquetados.add(nodoDestino);
				}
			}
			// por ser bidireccionales
			nodoDestino = arista.getNodoOrigen();

			if (!nodoDestino.isVisitado()) {
				if (arista.getPeso() + recorridoPrevio + cambioLinea < nodoDestino
						.getRecorrido()) {
					nodosEtiquetados.remove(nodoDestino);
					nodoDestino.setRecorrido(arista.getPeso() + recorridoPrevio
							+ cambioLinea);
					nodoDestino.setLinea(arista.getLinea());
					nodosEtiquetados.add(nodoDestino);
				}
			}
		}

		for (Nodo nodoEtiquetado : nodosEtiquetados) {
			if (nodoEtiquetado.getRecorrido() < min) {

				min = nodoEtiquetado.getRecorrido();
				siguiente = nodoEtiquetado;
			}
		}

		if (nodosEtiquetados.size() > 0) {

			nodosEtiquetados.remove(siguiente);

			solve(siguiente, siguiente.getRecorrido());

		} else {

			List<Nodo> nodos = nodosExistentes.get(nodoFinal);

			if (nodos == null) {
				System.out.println("IMPOSSIBLE");
			} else {
				boolean impossible = false;
				min = Integer.MAX_VALUE;
				for (Nodo nodoF : nodos) {
					if (!nodoF.isVisitado()) {
						impossible = true;
						break;
					}
					min = Math.min(min, nodoF.getRecorrido());
				}
				if (impossible) {
					System.out.println("IMPOSSIBLE");
				} else {
					System.out.println(min);
				}
			}
		}
	}
}

class Arista {
	private Nodo nodoOrigen;
	private Nodo nodoDestino;
	private int peso;
	private boolean valida;
	private int linea;

	@Override
	public String toString() {
		return "origen = " + nodoOrigen.getValue() + " ; destino = "
				+ nodoDestino.getValue() + " ; peso = " + peso + " ; linea = "
				+ linea;
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

	public boolean isValida() {
		return valida;
	}

	public void setValida(boolean valida) {
		this.valida = valida;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}
}

class Nodo {

	private int value;
	private List<Arista> aristas;
	private int recorrido;
	private boolean visitado;
	private int linea;

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

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}

	@Override
	public String toString() {
		return "nodo = " + value + "; recorrido = " + recorrido + " ; linea="
				+ linea;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

}
