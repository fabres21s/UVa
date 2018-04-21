import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10035 - Primary Arithmetic
*
*
*	Submission:	9212851
*	Date:		2011-09-01 19:17:04
*	Runtime:	1.728
*	Ranking:	17987
*/
public class Main10035 {

	/**
	 * - Proceso matem�tico
	 */
	public static void main(String[] args) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String linea, aux;
		int llevo, carry, dif, i;
		String[] tokens, tokens1, tokens2;
		while (!(linea = reader.readLine()).equals("0 0")) {
			tokens = linea.split(" ");
			tokens1 = tokens[0].split("");
			tokens2 = tokens[1].split("");
			carry = 0;
			aux = "";
			if (tokens1.length != tokens2.length) {
				dif = Math.abs(tokens1.length - tokens2.length);
				if (tokens1.length > tokens2.length) {
					for (i = 1; i < tokens1.length; i++) {
						if ((i - 1) < dif)
							aux += "0";
						else
							aux += tokens2[i - dif];
					}
					tokens2 = aux.split("");
				} else {
					for (i = 1; i < tokens2.length; i++) {
						if ((i - 1) < dif)
							aux += "0";
						else
							aux += tokens1[i - dif];
					}
					tokens1 = aux.split("");
				}
			}
			llevo = 0;
			for (i = tokens1.length - 1; i > 0; i--) {
				if ((Integer.valueOf(tokens1[i]) + Integer.valueOf(tokens2[i]) + llevo) >= 10) {
					carry++;
					llevo = 1;
				} else
					llevo = 0;
			}
			if (carry == 0)
				System.out.println("No carry operation.");
			else {
				if (carry == 1)
					System.out.println("1 carry operation.");
				else
					System.out.println(carry + " carry operations.");
			}
		}
	}
}
