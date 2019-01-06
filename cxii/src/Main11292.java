import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
*	11292 - Dragon of Loowater
*
*	Submission:	22556291
*	Date:		2019-01-04 19:25:13
*	Runtime:	0.140
*	Ranking:	5952
*/
public class Main11292 {

	/**
	 * - Priority Queue
	 * - Simulación
	 * 
	 * Un dragón tiene h cabezas de determinada altura y hay k caballeros de cierta altura
	 * un caballero le puede cortar la cabeza al dragón sólo si es igual de grande que la cabeza
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int heads, knights;

		StringBuffer output = new StringBuffer();
		int heightKnight, res = 0;
		while (!(line = br.readLine()).equals("0 0")) {
			args = line.split(" ");
			heads = Integer.parseInt(args[0]);
			knights = Integer.parseInt(args[1]);

			PriorityQueue<Integer> queueHeads = new PriorityQueue<Integer>();

			for (int i = 0; i < heads; i++) {
				queueHeads.add(Integer.valueOf(br.readLine()));
			}

			PriorityQueue<Integer> queueKnights = new PriorityQueue<Integer>();

			for (int i = 0; i < knights; i++) {
				queueKnights.add(Integer.valueOf(br.readLine()));
			}

			res = 0;

			while (!queueKnights.isEmpty() && !queueHeads.isEmpty()) {
				heightKnight = queueKnights.poll();

				if (queueHeads.peek() <= heightKnight) {
					res += heightKnight;
					queueHeads.poll();
				}
			}

			output.append(queueHeads.isEmpty() ? res : "Loowater is doomed!");
			output.append("\n");
		}
		System.out.print(output);
	}

}
