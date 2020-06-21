import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
*	1056 - Degrees of Separation
*
*
*	Submision:	16555243
*	Date:		2015-12-08 12:31:36
*	Runtime:	0.285
*	Ranking:	1172 / 1254
*/
public class Main1056 {

	/**
	 * - Grafos bidireccionales
	 * - Búsqueda en profundidad
	 * - Queue
	 * 
	 * Hallar el máximo grado de separación entre un grupo de personas
	 * con unas relaciones preestablecidas
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int personas, relaciones;
		int persona1, persona2;
		String nombre1, nombre2;
		StringBuffer output = new StringBuffer();
		boolean firstLine=true;
		int casos = 0;
		Grafo grafo = new Grafo();
		while (input.hasNext()){
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			personas = input.nextInt();
			relaciones = input.nextInt();
			
			if (personas == 0 && relaciones == 0){
				break;
			}
			
			if (!firstLine) {
				/*
				 * No es el primer caso de prueba, tampoco el último
				 */
				output.append("\n");
			}
			firstLine = false;
			
			//long t = System.currentTimeMillis();
			
			grafo.createNodes(personas);
			for (int i = 0 ; i<relaciones; i++){
				nombre1 = input.next();
				nombre2 = input.next();
				
				if (map.get(nombre1) == null){
					map.put(nombre1, map.size());
				} 
				persona1 = map.get(nombre1);
				
				if (map.get(nombre2) == null){
					map.put(nombre2, map.size());
				} 
				persona2 = map.get(nombre2);
				grafo.addAdyacente(persona1, persona2);
				grafo.addAdyacente(persona2, persona1);
				
			}
	
			int max =-1;
			for (int i = 0; i <personas; i++){
				relaciones = grafo.solve(i);
				if (relaciones == -1){
					max = -1;
					break;
				}
				if (relaciones > max){
					max = relaciones;
				}
			}
		
			  casos ++;
			    output.append("Network "+casos+": ");
			    if(max == -1){
			    	output.append("DISCONNECTED");
			    	
			    } else {
			    	output.append(max);
			    }
			    output.append("\n");
			    
			    //System.out.println("time >>  "+(System.currentTimeMillis()-t));

		}
		System.out.println(output);
		input.close();
	}
	
}


class Grafo {

	List<Nodo> nodos = new ArrayList<Nodo>();
	int arreglo [];
	
	public void createNodes(int qty) {
		nodos.clear();
		for (int i = 0; i < qty; i++) {
			Nodo nodo = new Nodo();

			nodo.setValue(i);
			nodo.setVisitado(false);
			nodo.setAdyacentes(new ArrayList<Nodo>());
			nodos.add(nodo);
		}
		arreglo = new int[qty];

	}

	public void addAdyacente(int origen, int destino) {
		Nodo nodoOrigen = nodos.get(origen);
		Nodo nodoDestino = nodos.get(destino);
		nodoOrigen.getAdyacentes().add(nodoDestino);
	}

	public int solve(int source) {

		clear();
		Nodo nodoOrigen = nodos.get(source);
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
					nodo.setDia(nodo2.getDia() + 1);
					arreglo[nodo.getDia()]++;
					queue.add(nodo);
				}
			}
		}
		
		int max = -1;
		
		for (Nodo nodo : nodos) {
			if (!nodo.isVisitado()){
				return -1;
			}
			
			if (nodo.getDia() > max){
				max = nodo.getDia();
			}
		}
		
		return max;
	//	print();

	}

	public void clear() {
		for (Nodo nodo : nodos) {
			nodo.setVisitado(false);
			nodo.setDia(-1);
		}
		arreglo = new int[nodos.size()];
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

/*
4 4
a b b c c d d a
10 12
a b
a c
b c
b d
c f
c g
g h
h i
i e
d e
f e
e j
2 2
a b
b b
0 0*/