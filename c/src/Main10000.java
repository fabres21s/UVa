import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
*	10000 - Longest Paths
*
*	Submission:	25729032
*	Date:		2020-11-16 15:11:47
*	Runtime:	0.680
*	Ranking:	4219 / 5055
*/
public class Main10000 {

	/**
	 *  - Dijkstra
	 *  
	 *  Hallar la recorrido más largo posible de un punto A a un punto B
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		int nodos = 0, testCases = 0;

		String line;
		while ((nodos = Integer.valueOf(br.readLine())) != 0) {
			
		
			testCases++;
			Grafo10000 grafo = new Grafo10000(nodos);

			Nodo10000 nodoInicial = grafo.getNodo(Integer.parseInt(br.readLine()));
			nodoInicial.setRecorrido(0);

			while (!(line = br.readLine()).equals("0 0")) {
				args = line.split(" ");
				grafo.addAdyacente(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 1);
			}

			output.append(String.format("Case %d: ", testCases));
			output.append(grafo.solve(nodoInicial));
		}
		System.out.print(output);
	}

}

class Grafo10000 {

	int max = Integer.MAX_VALUE;
	private List<Nodo10000> nodosEtiquetados;
	private List<Nodo10000> nodosExistentes;
	public String nodoFinal;

	public Grafo10000(int nodos) {
		nodosExistentes = new ArrayList<Nodo10000>();
		nodosEtiquetados = new ArrayList<Nodo10000>();
		for (int i = 1; i <= nodos; i++) {
			nodosExistentes.add(new Nodo10000(i));
		}
	}

	public Nodo10000 getNodo(int value) {
		return nodosExistentes.stream().filter(x -> x.getValue() == value).findFirst().get();
	}

	public void addAdyacente(int origen, int destino, int peso) {

		Nodo10000 nodoOrigen = nodosExistentes.stream().filter(x -> x.getValue() == origen).findFirst().get();
		Nodo10000 nodoDestino = nodosExistentes.stream().filter(x -> x.getValue() == destino).findFirst().get();

		Arista10000 arista = crearArista(nodoOrigen, nodoDestino, peso);
		nodoOrigen.getAristas().add(arista);

	}

	private Arista10000 crearArista(Nodo10000 nodoOrigen, Nodo10000 nodoDestino, int peso) {
		Arista10000 arista = new Arista10000();
		arista.setNodoDestino(nodoDestino);
		arista.setNodoOrigen(nodoOrigen);
		arista.setPeso(peso);
		return arista;
	}

	public String solve(Nodo10000 nodoOrigen) {

		nodosEtiquetados.add(nodoOrigen);

		while (nodosEtiquetados.size() > 0) {

			Nodo10000 nodo = nodosEtiquetados.get(0);
			for (Arista10000 arista : nodo.getAristas()) {

				Nodo10000 nodoDestino = arista.getNodoDestino();

				if ((nodo.getRecorrido() + arista.getPeso()) > nodoDestino.getRecorrido()) {
					nodoDestino.setRecorrido(nodo.getRecorrido() + arista.getPeso());
					nodosEtiquetados.add(nodoDestino);
				}

			}
			nodosEtiquetados.remove(0);
		}

		int max = -1;
		int nodoMax = -1;
		
		for (Nodo10000 nodo : nodosExistentes) {
			if (nodo.getRecorrido() > max) {
				max = nodo.getRecorrido();
				nodoMax = nodo.getValue();
			}
		}

		return String.format("The longest path from %d has length %d, finishing at %d.\n\n", nodoOrigen.getValue(), max, nodoMax);
	}
}

class Arista10000 {
	private Nodo10000 nodoOrigen;
	private Nodo10000 nodoDestino;
	private int peso;

	public Nodo10000 getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(Nodo10000 nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public Nodo10000 getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(Nodo10000 nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}

class Nodo10000 {

	private int value;
	private List<Arista10000> aristas;
	private int recorrido = Integer.MIN_VALUE;

	public Nodo10000(int value) {
		this.value = value;
		this.aristas = new ArrayList<Arista10000>();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Arista10000> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista10000> aristas) {
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
		return "nodo = " + value + "; Recorrido = " + recorrido;
	}


}
