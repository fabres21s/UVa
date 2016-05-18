import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author fabio
 *  
 * 		   10004 - Bicoloring
 * 
 *         Grafos, Bipartitos 
 *         Para que un grafo sea bipartito, bicoloreable, se
 *         debe cumplir que 2 nodos adyacentes le puedan ser asignados colores
 *         diferentes Se intentó hacerlo mediante conjuntos, llegada y salida
 *         (diágrama sagital) pero a pesar que coincidía con la salida del
 *         uDebug al enviarlo a UVa la respuesta era incorrecta
 *         
 *         Fecha de Envío:	2016-04-06 22:05
 *         Runtime:			0.050s
 *         Puesto:			11583
 */
public class Main10004 {



	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vertices, aristas;
		while (true) {

			vertices = Integer.parseInt(br.readLine());

			if (vertices == 0) {
				break;
			}

			aristas = Integer.parseInt(br.readLine());

			Grafo grafo = new Grafo();
			grafo.createNodes(vertices);
			for (int i = 0; i < aristas; i++) {
				args = br.readLine().split(" ");

				grafo.addAdyacente(Integer.parseInt(args[0]),
						Integer.parseInt(args[1]));
			}

			grafo.solve(0);
		}

	}

}

class Arista {
	private Nodo nodoOrigen;
	private Nodo nodoDestino;

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
}

class Grafo {

	List<Nodo> nodos = new ArrayList<Nodo>();
	List<Arista> aristas = new ArrayList<Arista>();

	public void createNodes(int qty) {
		nodos.clear();
		for (int i = 0; i < qty; i++) {
			Nodo nodo = new Nodo();

			nodo.setValue(i);
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
		}
	}

	public void addAdyacente(int origen, int destino) {
		Nodo nodoOrigen = nodos.get(origen);
		Nodo nodoDestino = nodos.get(destino);
		nodoDestino.getAdyacentes().add(nodoOrigen);
		nodoOrigen.getAdyacentes().add(nodoDestino);
	}

	public void solve(int source) {

		Nodo nodoOrigen = nodos.get(source);
		nodoOrigen.setVisitado(true);

		boolean bicolorable = true;
		// buscamos los adyacentes
		Queue<Nodo> queue = new LinkedList<Nodo>();
		int colorSet = 0;
		queue.add(nodoOrigen);
		while (!queue.isEmpty() && bicolorable) {
			// System.out.println("Grafo.solve()");
			Nodo nodo2 = queue.poll();
			if (nodo2.getColor() == 0) {
				nodo2.setColor(1);
				colorSet = 2;
			} else if (nodo2.getColor() == 1) {
				colorSet = 2;
			} else {
				colorSet = 1;
			}
			for (Nodo nodo : nodo2.getAdyacentes()) {

				if (nodo.getColor() == 0) {
					nodo.setColor(colorSet);
				} else {
					if (nodo.getColor() != colorSet) {
						bicolorable = false;
						break;
					}
				}

				if (!nodo.isVisitado()) {
					nodo.setVisitado(true);
					queue.add(nodo);
				}
			}
		}
		System.out.println(bicolorable ? "BICOLORABLE." : "NOT BICOLORABLE.");

	}

	private void print() {
		for (Nodo nodo : nodos) {
			System.out.println(nodo);
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
	private int color = 0;

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
		return value + " -  color = " + color + " -  ";
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}

/*
 * 4 4 a b b c c d d a 10 12 a b a c b c b d c f c g g h h i i e d e f e e j 2 2
 * a b b b 0 0
 */