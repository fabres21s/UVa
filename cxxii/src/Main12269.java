import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
*	12269 - Lawn mower
*
*
*	Submission:	20400090
*	Date:		2017-11-26 02:15:41
*	Runtime:	0.180
*	Ranking:	413
*/
public class Main12269 {

	/**
	 * - Validaciones
	 *
	 *  Validar si un césped es cortado correctamente, teniendo en cuenta el ancho del campo
	 *  y el ancho del corte
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int nx = 1, ny = 1;
		double w;

		while (nx > 0) {
			args = br.readLine().split(" ");
			nx = Integer.parseInt(args[0]);
			ny = Integer.parseInt(args[1]);
			w = Double.parseDouble(args[2]) / 2;

			if (nx > 0) {
				
				if (validateCuts(nx, 75, br.readLine().split(" "), w) ) {
					if (validateCuts(ny, 100, br.readLine().split(" "), w)) {
						output.append("YES");
					} else {
						output.append("NO");
					}
				} else {
					br.readLine();
					output.append("NO");
				}
				
				output.append("\n");
				

			}
		}
		System.out.print(output);
	}

	private static boolean validateCuts(int size, int measure, String args[], double w) {
		double cuts[] = new double[size];
		for (int i = 0; i < size; i++) {
			cuts[i] = Double.parseDouble(args[i]);
		}
		Arrays.sort(cuts);
		double menor = 0;
		double mayor = 0;

			for (int i = 0; i < size; i++) {
				menor = cuts[i] - w;
				if (menor > mayor) {
					return false;
				}
				mayor = cuts[i] + w;
				
			}
		return mayor >= measure;	
	}

}
