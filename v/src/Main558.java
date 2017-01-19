import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main558 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner input = new Scanner(System.in);

		int testCases = input.nextInt();

		int systems, wormholes;
		for (int i = 0; i < testCases; i++) {

			systems = input.nextInt();
			wormholes = input.nextInt();

			Grafo558 grafo = new Grafo558();
			grafo.createNodes(wormholes);

			for (int j = 0; j < wormholes; j++) {

				grafo.addAdyacente(input.nextInt(), input.nextInt(), input.nextInt());
			}

			grafo.solve(grafo.getNodo(0), 0);

			System.out.println(grafo.isPossible() ? "possible" : "not possible");
		}
	}

}

class Grafo558 {

	int max = Integer.MAX_VALUE;
	private List<Nodo558> nodosEtiquetados;
	private List<Nodo558> nodosVisitados;
	private boolean possible;

	public String nodoFinal;
	Map<Integer, Nodo558> nodosExistentes;

	public void createNodes(int qty) {

		setPossible(false);
		nodosEtiquetados = new ArrayList<Nodo558>();
		nodosExistentes = new HashMap<Integer, Nodo558>();
		nodosVisitados = new ArrayList<Nodo558>();
		max = Integer.MAX_VALUE;
	}

	public Nodo558 getNodo(int origen) {

		return nodosExistentes.get(origen);

	}

	public void addAdyacente(int origen, int destino, int peso) {

		Nodo558 nodoOrigen = getNodo(origen);

		if (nodoOrigen == null) {
			nodoOrigen = crearNodo(origen);
			nodosExistentes.put(origen, nodoOrigen);
		}

		Nodo558 nodoDestino = getNodo(destino);

		if (nodoDestino == null) {
			nodoDestino = crearNodo(destino);
			nodosExistentes.put(destino, nodoDestino);
		}

		Arista558 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);

	}

	private Arista558 crearArista(Nodo558 nodoOrigen, Nodo558 nodoDestino, int peso) {
		Arista558 arista = new Arista558();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);

		return arista;
	}

	private Nodo558 crearNodo(int value) {
		Nodo558 nodo = new Nodo558();
		nodo.setValue(value);
		nodo.setRecorrido(max);
		nodo.setAristas(new ArrayList<Arista558>());
		return nodo;
	}

	public void solve(Nodo558 nodo, int recorridoPrevio) {

		try {
			nodo.setRecorrido(recorridoPrevio);
			nodosEtiquetados.remove(nodo);
			nodosVisitados.add(nodo);

			int max = Integer.MAX_VALUE;
			Nodo558 siguiente = new Nodo558();
			for (Arista558 arista : nodo.getAristas()) {

				Nodo558 nodoDestino = arista.getNodoDestino();

				if (nodoDestino.getRecorrido() > recorridoPrevio + arista.getPeso()) {
					nodosEtiquetados.remove(nodoDestino);
					nodoDestino.setRecorrido(recorridoPrevio + arista.getPeso());
					nodosEtiquetados.add(nodoDestino);
				}
			}

			for (Nodo558 nodoEtiquetado : nodosEtiquetados) {
				if (nodoEtiquetado.getRecorrido() < max) {

					max = nodoEtiquetado.getRecorrido();
					siguiente = nodoEtiquetado;
				}
			}

			if (nodosEtiquetados.size() > 0) {

				nodosEtiquetados.remove(siguiente);

				if (nodosVisitados.contains(siguiente)) {
					possible = true;
					return;
				}

				solve(siguiente, siguiente.getRecorrido());

			}
		} catch (Exception exc) {
			//las cosas que no se entienden, sin el try catch, me daba Runtime Error, pero al menos lo aceptó :|
		}
	}

	public boolean isPossible() {
		return possible;
	}

	public void setPossible(boolean possible) {
		this.possible = possible;
	}
}

class Arista558 {
	private Nodo558 nodoOrigen;
	private Nodo558 nodoDestino;
	private int peso;

	@Override
	public String toString() {
		return "origen = " + nodoOrigen.getValue() + " ; destino = " + nodoDestino.getValue() + " ; peso = " + peso;
	}

	public Nodo558 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo558 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo558 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo558 nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}

class Nodo558 {

	private int value;
	private List<Arista558> aristas;
	private int recorrido;
	// List<Integer> weights

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Arista558> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista558> aristas) {
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
		return "nodo = " + value + "; recorrido = " + recorrido;
	}

}
