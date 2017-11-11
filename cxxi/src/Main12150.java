import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
*	12150 - Pole Position
*
*	Submision:	20249146
*	Date:		2017-10-26 22:07:00
*	Runtime:	0.090
*	Ranking:	561
*/
public class Main12150 {

	/**
	 * - Simulación
	 * 
	 *  Dados unos carros y las posiciones que han ganado en una carrera, determinar el orden de salida inicial
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int cars, car, position;

		while ((cars = Integer.parseInt(br.readLine())) != 0) {
			int polePosition[] = new int[cars];
			boolean correct = true;

			for (int c = 0; c < cars; c++) {
				args = br.readLine().split(" ");
				car = Integer.parseInt(args[0]);
				position = Integer.parseInt(args[1]) + c;

				if (correct) {
					if (position >= cars || position < 0) {
						correct = false;
					} else {
						if (polePosition[position] == 0) {
							polePosition[position] = car;
						} else {
							correct = false;
						}
					}
				}
			}
			
			if (correct) {
				output.append(Arrays.toString(polePosition).replaceAll(",", "").replaceAll("[\\[]", "").replaceAll("[\\]]", ""));
			} else {
				output.append("-1");
			}
			output.append("\n");
		}

		System.out.print(output);
	}

}
