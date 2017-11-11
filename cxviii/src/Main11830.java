import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
*	11830 - Contract Revision
*
*
*	Submision:	20332520
*	Date:		2017-11-11 15:58:37
*	Runtime:	0.210
*	Ranking:	1427
*/
public class Main11830 {

	/**
	 * - Reemplazar
	 * 
	 *  En una cadena de números, reemplazar un número dado
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		String line;
		while (!(line = br.readLine()).equals("0 0")) {
			args = line.split(" ");
			output.append(getValue(args[0], args[1]));
			output.append("\n");
		}
		System.out.print(output);
	}

	private static BigInteger getValue(String replace, String replacement) {

		String number = replacement.replaceAll(replace, "");
		return new BigInteger(number.length() == 0 ? "0" : number);
	}

}
