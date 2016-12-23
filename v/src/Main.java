import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
*	10801 - Lift Hopping
*
*
*	Submision:	16889535
*	Date:		2016-02-23 03:21:05
*	Runtime:	0.092
*	Ranking:	1851
*/
public class Main {

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
	 * Uno de los más completos que he hecho
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String city1, city2;
		int weight;
		int cities, roads;
		while (!(line = br.readLine()).equals("0 0")) {
			args = line.split(" ");
			
			cities = Integer.parseInt(args[0]);
			roads = Integer.parseInt(args[1]);
			
			Grafo544 grafo544 = new Grafo544();
			grafo544.createNodes(cities);
			for (int i=0; i<roads; i++) {
				args = br.readLine().split(" ");
				city1 = args[0];
				city2 = args[1];
				weight = Integer.parseInt(args[2]);
				
				grafo544.addAdyacente(city1, city2, weight);
			}
			
			args = br.readLine().split(" ");
			city1 = args[0];
			city2 = args[1];
			
			grafo544.solve(grafo544.getNodo(city1), 0);
			System.out.println(grafo544.getNodo(city2).getMinWeight());
			
		}
		
		
		
		
	}
}

class Grafo544 {

	int max = Integer.MAX_VALUE;
	private List<Nodo544> nodosEtiquetados;
	public String nodoFinal;
	Map<String, List<Nodo544>> nodosExistentes;

	public void createNodes(int qty) {

		nodosEtiquetados = new ArrayList<Nodo544>();
		nodosExistentes = new HashMap<String, List<Nodo544>>();
		max = Integer.MAX_VALUE;
	}

	public Nodo544 getNodo(String origen) {
		
		return nodosExistentes.get(origen).get(0);
		
	}

	public void addAdyacente(String origen, String destino, int peso) {

		Nodo544 nodoOrigen = null;

		List<Nodo544> nodos = nodosExistentes.get(origen);

		if (nodos == null) {
			nodoOrigen = crearNodo(origen);
			nodos = new ArrayList<Nodo544>();
			nodos.add(nodoOrigen);
		} else {
			nodoOrigen = nodos.get(nodos.size() - 1); // traemos el último nodo
														// de las lista
			
		}
		nodosExistentes.put(origen, nodos);

		Nodo544 nodoDestino = null;

		nodos = nodosExistentes.get(destino);

		if (nodos == null) {
			nodos = new ArrayList<Nodo544>();
			nodoDestino = crearNodo(destino);
			nodos.add(nodoDestino);
		} else {
			nodoDestino = nodos.get(nodos.size() - 1); // traemos el último nodo
														// de las lista
			
		}

		nodosExistentes.put(destino, nodos);
		Arista544 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);
		nodoDestino.getAristas().add(arista);

	}

	private Arista544 crearArista(Nodo544 nodoOrigen, Nodo544 nodoDestino, int peso) {
		Arista544 arista = new Arista544();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		arista.setValida(true);

		return arista;
	}

	private Nodo544 crearNodo(String value) {
		Nodo544 nodo = new Nodo544();
		nodo.setValue(value);
		nodo.setRecorrido(max);
		nodo.setMinWeight(max);
		nodo.setAristas(new ArrayList<Arista544>());
		return nodo;
	}

	public void solve(Nodo544 nodo, int recorridoPrevio) {

		nodosEtiquetados.remove(nodo);
		nodo.setVisitado(true);


		int min = Integer.MAX_VALUE;
		Nodo544 siguiente = new Nodo544();
		for (Arista544 arista : nodo.getAristas()) {

			Nodo544 nodoDestino = arista.getNodoDestino();
			
			if (!nodoDestino.isVisitado()) {

				if (arista.getPeso() + recorridoPrevio  < nodoDestino
						.getRecorrido()) {
					nodosEtiquetados.remove(nodoDestino);
					nodoDestino.setRecorrido(arista.getPeso() + recorridoPrevio
							);
					
					if (arista.getPeso() < nodo.getMinWeight()) {
						nodo.setMinWeight(arista.getPeso());
					}
					
					if (nodoDestino.getMinWeight() > nodo.getMinWeight()) {
						nodoDestino.setMinWeight(nodo.getMinWeight());
					}
					nodosEtiquetados.add(nodoDestino);
				}
			}
			// por ser bidireccionales
			nodoDestino = arista.getNodoOrigen();

			if (!nodoDestino.isVisitado()) {
				if (arista.getPeso() + recorridoPrevio  < nodoDestino
						.getRecorrido()) {
					nodosEtiquetados.remove(nodoDestino);
					nodoDestino.setRecorrido(arista.getPeso() + recorridoPrevio
							);
					
					if (arista.getPeso() < nodo.getMinWeight()) {
						nodo.setMinWeight(arista.getPeso());
					}
					
					if (nodoDestino.getMinWeight() > nodo.getMinWeight()) {
						nodoDestino.setMinWeight(nodo.getMinWeight());
					}
					
					
					nodosEtiquetados.add(nodoDestino);
				}
			}
		}

		for (Nodo544 nodoEtiquetado : nodosEtiquetados) {
			if (nodoEtiquetado.getRecorrido() < min) {

				min = nodoEtiquetado.getRecorrido();
				siguiente = nodoEtiquetado;
			}
		}

		if (nodosEtiquetados.size() > 0) {

			nodosEtiquetados.remove(siguiente);
			
			
			solve(siguiente, siguiente.getRecorrido());

		
		}
	}
}

class Arista544 {
	private Nodo544 nodoOrigen;
	private Nodo544 nodoDestino;
	private int peso;
	private boolean valida;
	private int linea;

	@Override
	public String toString() {
		return "origen = " + nodoOrigen.getValue() + " ; destino = "
				+ nodoDestino.getValue() + " ; peso = " + peso + " ; linea = "
				+ linea;
	}

	public Nodo544 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo544 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo544 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo544 nodoDestino) {
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

class Nodo544 {

	private String value;
	private List<Arista544> aristas;
	private int recorrido;
	private int minWeight;
	private boolean visitado;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Arista544> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista544> aristas) {
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

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public int getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(int minWeight) {
		this.minWeight = minWeight;
	}

}
