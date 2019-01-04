import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//TODO - Poner información
public class Main11292 {

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
