import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10432 - Polygon Inside A Circle
*
*	Submission:	25787975
*	Date:		2020-11-30 15:15:00
*	Runtime:	0.110
*	Ranking:	6466 / 6683
*/
public class Main10432 {

	/**
	 * - Fórmula matemática
	 * 
	 *  Área de un polígono regular dentro de un círculo
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		double r, n;

		StringBuilder output = new StringBuilder();
		//while (!(line = br.readLine()).equals("")) {
		while ((line = br.readLine()) != null) {
			args = line.split(" ");
			r = Double.parseDouble(args[0]);
			n = Double.parseDouble(args[1]);
			output.append(String.format("%.03f\n", n * r * r * Math.sin(2 * Math.acos(-1) / n) / 2));
		}
		System.out.print(output);
	}

}
