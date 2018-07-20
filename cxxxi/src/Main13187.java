import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13187 - Felipe and the Sequence
*
*	Submision:	21634180
*	Date:		2018-07-19 20:31:34
*	Runtime:	0.310
*	Ranking:	156 / 224
*/
public class Main13187 {

	/**
	 * - Fórmula matemática
	 * 
	 * Dado S en la fórmula
	 * 
	 * 1/(√1 + √2) + 1/(√2 + √3) + ... 1/(√n + √(n+1)) = S
	 * Encontrar cuánto vale n
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int testCases = Integer.parseInt(br.readLine());
		long n, s;
		
		while (testCases --> 0) {
			s = Long.parseLong(br.readLine());
			
			n = s*s + 2*s;
			output.append(n);
			output.append("\n");
		}
		System.out.print(output);
	}

}
