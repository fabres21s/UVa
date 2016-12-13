import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
*	10034 - Freckles
*
*
*	Submision:	16917220
*	Date:		2016-02-27 23:22:56
*	Runtime:	0.215
*	Ranking:	5971
*/
public class Main10034 {

	/**
	 * - Grafos bidireccionales
	 * - Kruskal
	 * - Set
	 * - Recursividad
	 * 
	 * Hallar el árbol de
	 * expansión mínimo en un plano cartesiano en el que todos sus puntos se
	 * interconectan
	 * 
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCaases = input.nextInt();

		while (testCaases-- > 0) {
			Grafo_ grafo = new Grafo_();
			int freckles = input.nextInt();

			for (int i = 0; i < freckles; i++) {
				grafo.crearNodo(input.nextDouble(), input.nextDouble());
			}

			grafo.solve();
			if (testCaases > 0) {
				System.out.println();
			}
		}
		input.close();
	}
}

class Grafo_ {

	private List<Nodo> nodos;
	int max;
	int friendship;
	double recorrido;
	private List<Arista> aristas;
	private List<Arista> arbolExpansion;

	public Grafo_() {
		nodos = new ArrayList<Nodo>();
		aristas = new ArrayList<Arista>();
		max = 0;
		arbolExpansion = new ArrayList<Arista>();
	}

	public void crearNodo(double x, double y) {
		Nodo nodo = new Nodo();
		nodo.setLineas(new HashSet<Integer>());
		nodo.setComponenteX(x);
		nodo.setComponenteY(y);
		nodo.setVisitado(false);
		nodo.setAristas(new ArrayList<Arista>());

		for (Nodo n : nodos) {
			Arista arista = new Arista(nodo, n);
			nodo.getAristas().add(arista);
			n.getAristas().add(arista);
			aristas.add(arista);
		}
		nodos.add(nodo);
	}

	public void solve() {

		recorrido = 0;
		int conexiones = nodos.size() - 1;
		while (arbolExpansion.size() < conexiones) {
			double min = Double.MAX_VALUE;
			Arista aristaMenor = null;
			for (Arista arista : aristas) {
				// System.out.println("posibles "+arista.getPeso());
				if (arista.getPeso() < min) {
					min = arista.getPeso();
					aristaMenor = arista;
				}
			}

			validarArista(aristaMenor);

			// System.out.println("escogido = "+aristaMenor.getNodoOrigen()+"  :::: "+aristaMenor.getNodoDestino()
			// + "::: "+min);
			// System.out.println("tamaño del arbol "+arbolExpansion.size());
			aristaMenor.getNodoDestino().setVisitado(true);
			aristaMenor.getNodoOrigen().setVisitado(true);
			aristas.remove(aristaMenor);
		}
		System.out.printf("%.2f\n", recorrido);
	}

	private void validarArista(Arista aristaMenor) {
		Nodo nodoInicial = aristaMenor.getNodoOrigen();
		Nodo nodoFinal = aristaMenor.getNodoDestino();

		Set<Integer> lineas = nodoInicial.getLineas();

		int linea = arbolExpansion.size() + 1;

		for (Integer index : lineas) {
			if (nodoFinal.getLineas().contains(index)) {
				return;
			}
		}

		lineas = nodoFinal.getLineas();
		for (Integer index : lineas) {
			if (nodoInicial.getLineas().contains(index)) {
				return;
			}
		}
		aristaMenor.setValida(false);
		nodoInicial.getLineas().add(linea);
		nodoFinal.getLineas().add(linea);

		for (Integer index : nodoInicial.getLineas()) {
			broadcast(nodoInicial, index);
		}

		for (Integer index : nodoFinal.getLineas()) {
			broadcast(nodoFinal, index);
		}
		// broadcast

		arbolExpansion.add(aristaMenor);
		recorrido += aristaMenor.getPeso();
	}

	private void broadcast(Nodo nodo, int linea) {

		for (Arista arista : nodo.getAristas()) {
			if (!arista.isValida()) {
				Nodo nodo1 = arista.getNodoOrigen();
				if (nodo1.getLineas().add(linea)) {
					broadcast(nodo1, linea);
				}

				Nodo nodo2 = arista.getNodoDestino();
				if (nodo2.getLineas().add(linea)) {
					broadcast(nodo2, linea);
				}
			}
		}
	}

	class Arista {
		private Nodo nodoOrigen;
		private Nodo nodoDestino;
		private double peso;
		private boolean valida;

		public Arista(Nodo nodo, Nodo n) {

			setNodoDestino(nodo);
			setNodoOrigen(n);

			setValida(true);

			setPeso(Math
					.sqrt(Math.pow(
							(nodo.getComponenteX() - n.getComponenteX()), 2)
							+ Math.pow(
									(nodo.getComponenteY() - n.getComponenteY()),
									2)));
		}

		@Override
		public String toString() {
			return "origen = " + nodoOrigen + " ; destino = " + nodoDestino
					+ " ; peso = " + peso;
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

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public boolean isValida() {
			return valida;
		}

		public void setValida(boolean valida) {
			this.valida = valida;
		}
	}

	class Nodo {

		private int value;
		private List<Arista> aristas;
		private int recorrido;
		private boolean visitado;
		private double componenteX;

		private Set<Integer> lineas;

		public double getComponenteX() {
			return componenteX;
		}

		public void setComponenteX(double componenteX) {
			this.componenteX = componenteX;
		}

		public double getComponenteY() {
			return componenteY;
		}

		public void setComponenteY(double componenteY) {
			this.componenteY = componenteY;
		}

		private double componenteY;

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
			return "x = " + componenteX + "; y = " + componenteY;
		}

		public boolean isVisitado() {
			return visitado;
		}

		public void setVisitado(boolean visitado) {
			this.visitado = visitado;
		}

		public Set<Integer> getLineas() {
			return lineas;
		}

		public void setLineas(Set<Integer> lineas) {
			this.lineas = lineas;
		}
	}
}
