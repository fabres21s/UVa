import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
*	200 - Rare Order
*
*
*	Submission:	25139745
*	Date:		2020-06-14 15:35:00
*	Runtime:	0.340
*	Ranking:	5595
*/
public class Main200 {

	/**
	 * - Ordenación topológica
	 * - Grafos dirigidos
	 * - Stack
	 * - Recursividad
	 * 
	 * Encontrar el orden en un alfabeto "extraño"
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String line;
		while ((line = br.readLine()) != null) {
			
			
			Set<Character> set = new HashSet<Character>();
			List<String> list = new ArrayList<String>();
			
			do {
				
				char[] array = line.toCharArray();
				
				list.add(line.concat("##############################"));
				
				for (char mander: array) {
					set.add(mander);
				}
				
			} while (!(line = br.readLine()).equals("#"));
			
			Grafo200 grafo = new Grafo200();
			grafo.createNodes(set);
			
			encontrarPrecedencias(list, grafo);

			grafo.topologicalSort();
		}

	}

	private static void encontrarPrecedencias(List<String> list, Grafo200 grafo) {
		List<String> startsWith = list.stream().filter(x -> x.startsWith("#")).collect(Collectors.toList());
		if (startsWith.size() < list.size()) {
			
			String first = list.get(0).substring(0,1);
			for (String s: list) {
				String next = s.substring(0, 1);
				
				if (!first.equals(next) && !first.equals("#") && !next.equals("#")) {
					
					//System.out.println(first + ">>"+next);
					grafo.addAdyacente(first, next);
				}
				first = next;
			}
			
			for (int  i =0; i < list.size(); i++) {
				
				final String firstFinal = list.get(i).substring(0,1);
				List<String> startsWithFirst = list.stream().filter(x -> x.startsWith(firstFinal)).collect(Collectors.toList());
				
				if (startsWithFirst.size() > 1) {
					List<String> evaluar = new ArrayList<String>();
					for (String s: startsWithFirst) {
						evaluar.add(s.substring(1));
					}
					encontrarPrecedencias(evaluar, grafo);
				}
				
				i += startsWithFirst.size() - 1;
			}
		}
	}
}

class Grafo200 {

	List<Nodo200> nodos;

	public void createNodes(Set<Character> set) {
		nodos = new ArrayList<Nodo200>();
		for (Character c: set) {
			Nodo200 nodo = new Nodo200();

			nodo.setValue(String.valueOf(c));
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo200>());
			nodos.add(nodo);
		}
	}

	public void topologicalSort() {
		Stack<String> stack = new Stack<String>();
		for (Nodo200 nodo : nodos) {
			if (!nodo.isVisitado()) {
				topologicalSortUtil(nodo, stack);
			}
		}

		StringBuffer output = new StringBuffer();
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}

		System.out.println(output.toString().trim());
	}

	private void topologicalSortUtil(Nodo200 nodoOrigen, Stack<String> stack) {
		nodoOrigen.setVisitado(true);
		for (Nodo200 nodo : nodoOrigen.getAdyacentes()) {
			if (!nodo.isVisitado()) {
				topologicalSortUtil(nodo, stack);
			}
		}

		stack.push(nodoOrigen.getValue());
	}

	public void addAdyacente(String first, String next) {
		Nodo200 nodoOrigen = nodos.stream().filter(x -> x.getValue().equals(first)).findFirst().get();
		Nodo200 nodoDestino = nodos.stream().filter(x -> x.getValue().equals(next)).findFirst().get();
		nodoOrigen.getAdyacentes().add(nodoDestino);
	}

	public void clear() {
		for (Nodo200 nodo : nodos) {
			nodo.setVisitado(false);
		}
	}

}

class Nodo200 {

	private String value;
	private List<Nodo200> adyacentes;
	private boolean visitado;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public List<Nodo200> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(List<Nodo200> adyacentes) {
		this.adyacentes = adyacentes;
	}

	@Override
	public String toString() {
		return value + "  -  " + visitado;
	}

}
