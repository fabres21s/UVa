import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


/**
*	1197 - The Suspects
*
*
*	Submission:	17196971
*	Date:		2016-04-13 17:26:45
*	Runtime:	0.250
*	Ranking:	609
*/
public class Main1197 {

	/**
	 * - Grafos bidireccionales
	 * - B�squeda en profundidad
	 * - Queue
	 * 
	 * Encontrar cuantos nodos est�n conectados al nodo 0
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuffer output = new StringBuffer();
		int persons, groups;

		while (true) {
			persons = input.nextInt();
			groups = input.nextInt();

			if (persons == 0 && groups == 0) {
				break;
			}

			DisjoinSets ds = new DisjoinSets();
			ds.makeSet(0);
			int origen, destino, miembros;
			for (int i = 0; i < groups; i++) {
				miembros = input.nextInt();

				origen = input.nextInt();
				ds.makeSet(origen);
				for (int j = 1; j < miembros; j++) {
					destino = input.nextInt();
					ds.makeSet(destino);
					ds.union(ds.map.get(origen), ds.map.get(destino));
				}
			}
			int value = ds.find(ds.map.get(0));
			output.append(String.format("%d\n", ds.nMap.get( value)));
			
		}
		System.out.print(output);

		input.close();
	}
	
	static class DisjoinSets {

	    List<Integer> parent, rank;
	    HashMap<Integer, Integer> map;
	    HashMap<Integer, Integer> nMap;
	    int total;

	    public DisjoinSets() {
	        map = new HashMap<Integer, Integer>();
	        nMap = new HashMap<Integer, Integer>();
	        parent = new ArrayList<Integer>();
	        rank = new ArrayList<Integer>();
	        total = 0;
	    }

	    void makeSet(Integer s) {
	        if (!map.containsKey(s)) {
	            map.put(s, total);
	            parent.add(total);
	            rank.add(0);
	            nMap.put(total, 1);
	            total++;
	        }
	    }

	    void union(int x, int y) {
	        int px = find(x);
	        int py = find(y);
	        if (px != py) {
	            int totalFriend = nMap.get(px) + nMap.get(py);
	            nMap.put(px, totalFriend);
	            nMap.put(py, totalFriend);
	        }
	        if (rank.get(px) > rank.get(py)) {
	            parent.set(py, px);
	        } else {
	            parent.set(px, py);
	        }
	        if (rank.get(px) == rank.get(py)) {
	            rank.set(py, rank.get(py) + 1);
	        }
	    }

	    int find(int x) {
	        if (x != parent.get(x)) {
	            parent.set(x, find(parent.get(x)));
	        }
	        return parent.get(x);
	    }
	}

}



