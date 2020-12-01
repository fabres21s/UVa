import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
*	10954 - Add All
*
*
*	Submission:	18525590
*	Date:		2016-12-20 16:23:47
*	Runtime:	0.140
*	Ranking:	8155 / 10714
*/
public class Main10954 {

	/**
	 * - Priority Queue
	 * - Proceso Matemático
	 * 
	 * Ir haciendo unas sumas sucesivas
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
			
			args = br.readLine().split(" ");
			for (String s : args) {
				priorityQueue.add(Integer.parseInt(s));
			}
			
			int total=0, cost = 0;
			
			while (priorityQueue.size() > 1) {
				total = priorityQueue.poll();
				total += priorityQueue.poll();
				cost += total;
				priorityQueue.add(total);
			}
			System.out.println(cost);
		}
	}

}
