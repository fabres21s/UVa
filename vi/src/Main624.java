import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
*	624 - CD
*
*	Submission:	21310027
*	Date:		2018-05-14 12:48:15
*	Runtime:	0.120
*	Ranking:	4590
*/
public class Main624 {

	static int max, songs, best;
	static Integer[] duration;
	static List<Integer> bestPath;

	/**
	 * - Recursividad
	 * - Búsqueda en profundidad
	 * 
	 * Buscar la máxima posible suma en un arreglo con un máximo determinado
	 * además de mostrar cuáles fueron los números que se sumaron
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			args = line.split(" ");

			max = Integer.parseInt(args[0]);
			songs = Integer.parseInt(args[1]);
			duration = new Integer[songs];

			for (int i = 2; i < songs + 2; i++) {
				duration[i - 2] = Integer.parseInt(args[i]);
			}
			best = 0;
			for (int i = 0; i < songs; i++) {
				List<Integer> path = new ArrayList<Integer>();
				dfs(path, 0, i);
			}

			for (int index : bestPath) {
				output.append(index);
				output.append(" ");
			}
			output.append("sum:");
			output.append(best);
			output.append("\n");

		}
		System.out.print(output);
	}

	private static void dfs(List<Integer> path, int sum, int index) {
		sum += duration[index];
		path.add(duration[index]);

		if (sum > best || (sum == best && path.size() > bestPath.size())) {
			best = sum;
			bestPath = new ArrayList<>(path);
		}

		for (int i = index + 1; i < songs; i++) {
			if ((sum + duration[i]) <= max) {
				dfs(path, sum, i);
				path.remove(duration[i]);
			}
		}
	}
}
