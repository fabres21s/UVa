import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
*	10041 - Vito's Family
*
*
*	Submision:	9306683
*	Date:		2011-09-27 20:00:33
*	Runtime:	0.400
*	Ranking:	9710
*/
public class Main10041 {

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		while (T-- != 0) {
			StringTokenizer tokens = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int[] rel = new int[r];
			while (--r != -1)
				rel[r] = Integer.parseInt(tokens.nextToken());
			Arrays.sort(rel);
			r = rel.length;
			int sum = 0, median = r % 2 == 0 ? (rel[r / 2] + rel[r / 2 - 1]) / 2
					: rel[r / 2];
			for (int i = 0; i < rel.length; i++)
				sum += Math.abs(rel[i] - median);
			System.out.println(sum);
		}


	}

}
