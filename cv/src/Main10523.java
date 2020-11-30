import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
*	10523 - Very Easy !!!
*
*	Submission:	25788075
*	Date:		2020-11-30 15:28:25
*	Runtime:	0.420
*	Ranking:	1043 / 3986
*/
public class Main10523 {
	
	/**
	 * - Fórmula matemática
	 * - BigInteger
	 * 
	 * Aplicar fórmula de sumatoria que indican en la descripción del ejercicio
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		BigInteger  a, sum;
		int N;
		String line;
		while ((line = br.readLine()) != null) {
			args = line.split(" ");
			N = Integer.valueOf(args[0]);

			a = BigInteger.valueOf(Integer.valueOf(args[1]));
			sum = BigInteger.ZERO;

			for (int i = 1; i <= N; i++) {
				sum = sum.add(BigInteger.valueOf(i).multiply(a.pow(i)));
			}

			output.append(sum  + "\n");
		}
		System.out.print(output);

	}

}
