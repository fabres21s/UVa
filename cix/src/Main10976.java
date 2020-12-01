import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10976 - Fractions Again?!
*
*	Submission:	25793819
*	Date:		2020-12-01 20:37:36
*	Runtime:	0.090
*	Ranking:	5256 / 5847
*/
public class Main10976 {

	/**
	 * - Fórmmula
	 * 
	 * Encontrar los valores para x e y que dado k cumplen que 1/k = 1/x + 1/y
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			int k = Integer.parseInt(s);
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for (double y = k + 1; y <= 2 * k; y++) {
				double x = (k * y) / (y - k);
				if ((int) (double) x == x) {
					sb.append("1/");
					sb.append(k);
					sb.append(" = 1/");
					sb.append((int) x);
					sb.append(" + 1/");
					sb.append((int) y);
					sb.append("\n");
					count++;
				}
			}
			System.out.println(count);
			System.out.print(sb.toString());
		}
	}

}
