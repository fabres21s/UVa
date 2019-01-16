import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	537 - Artificial Intelligence?
*
*
*	Submission:	22562897
*	Date:		2019-01-06 01:08:13
*	Runtime:	0.050
*	Ranking:	4254
*/
public class Main537 {

	/**
	 * - Validaciones
	 * - Cadenas de caracteres
	 * 
	 *  De un enunciado, sacar 2 datos entre I, P y U y calcular el faltante
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuffer output = new StringBuffer();
		double MAX = Double.MAX_VALUE;
		int testCases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCases; i++) {
			String line = br.readLine();
			double P = MAX, U = MAX, I = MAX;
			args = line.split("=");
			for (int x = 0; x < args.length; x++) {

				String s = args[x];
				if (s.endsWith("I")) {
					I = getValue(args[x + 1], "A");
				} else if (s.endsWith("P")) {
					P = getValue(args[x + 1], "W");
				} else if (s.endsWith("U")) {
					U = getValue(args[x + 1], "V");
				}

			}

			output.append(String.format("Problem #%d\n", i));
			if (I == MAX) {
				I = P / U;
				output.append(String.format("I=%.2fA\n\n", I));
			} else if (P == MAX) {
				P = I * U;
				output.append(String.format("P=%.2fW\n\n", P));
			} else {
				U = P / I;
				output.append(String.format("U=%.2fV\n\n", U));
			}
		}
		System.out.print(output);

	}

	private static double getValue(String string, String unit) {
		int pos = string.indexOf(unit);
		char prefix = string.charAt(pos - 1);
		if (prefix == 'm' || prefix == 'k' || prefix == 'M') {
			pos--;
		}

		String num = string.substring(0, pos);
		return getValueFromPrefix(Double.valueOf(num), prefix);
	}

	private static double getValueFromPrefix(double value, char s) {
		if (s == 'm') {
			return value / 1000;
		} else if (s == 'k') {
			return value * 1000;
		} else if (s == 'M') {
			return value * 1000000;
		}
		return value;
	}

}
