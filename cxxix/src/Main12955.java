import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	12955 - Factorial
*
*
*	Submision:	17623797
*	Date:		2016-07-05 17:28:59
*	Runtime:	0.030
*	Ranking:	229
*/
public class Main12955 {

	static int factorials[] = { 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 403200 };

	/*
	 * - Factorial
	 * 
	 * Encontrar la mínima cantidad de factoriales que, sumados de el valor n
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		String line;
		int n;
		while ((line = br.readLine()) != null) {
			n = Integer.parseInt(line);
			int count = 0;
			while (n > 0) {
				n -= evalute(n);
				count++;
			}
			output.append(count + "\n");
		}
		System.out.print(output);
	}

	private static int evalute(int n) {
		for (int i = 0; i < 10; i++) {
			if (factorials[i] > n) {
				return factorials[i - 1];
			} else if (factorials[i] == n) {
				return factorials[i];
			}
		}
		return 0;
	}

}
