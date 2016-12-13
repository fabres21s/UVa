import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
*	459 - Graph Connectivity
*
*
*	Submision:	16878981
*	Date:		2016-02-21 03:22:42
*	Runtime:	0.049
*	Ranking:	4453
*/
public class Main459 {

	/**
	 * - Grafos bidireccionales
	 * - Búsqueda en profundidad
	 * - Queue
	 */
	public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


		int cases = Integer.valueOf(input.readLine());
		int letras;
		StringBuffer output = new StringBuffer();
		input.readLine();
		while (cases -- > 0){
			
			String p= input.readLine();
			letras = p.charAt(0) - 64;

			Grafo grafo = new Grafo();
			grafo.createNodes(letras);
			
			String pair = input.readLine();
			
			while( pair != null) { 
				if (pair.length() > 1){
				grafo.addAdyacente(pair.charAt(0) - 64, pair.charAt(1) -64);
				pair = input.readLine();
				} else {
					break;
				}
				
			}
			
			for (int i = 1; i<= letras; i++) {
				grafo.solve(i);
			}
			output.append(grafo.max+"\n");
			if (cases != 0){
				output.append("\n");
			}
		}
		System.out.print(output);
	}

}

class Grafo {

	List<Nodo> nodos;
	int max;

	public void createNodes(int qty) {
		nodos = new ArrayList<Nodo>();
	//	System.out.println("Grafo.createNodes() "+qty);
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

		// System.out.println("Grafo.addAdyacente() "+origen+"  "+destino);

		if (nodos.size() >=origen && nodos.size() >= destino) {
			Nodo nodoOrigen = nodos.get(origen);
			Nodo nodoDestino = nodos.get(destino);
			nodoOrigen.getAdyacentes().add(nodoDestino);
			nodoDestino.getAdyacentes().add(nodoOrigen);
		}
	}

	public void solve(int source) {

		Nodo nodoOrigen = nodos.get(source);

		if (!nodoOrigen.isVisitado()) {
			max++;
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
						queue.add(nodo);
					}
				}
			}

			
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
