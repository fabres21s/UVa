import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
*	13185 - DPA Numbers
*
*
*	Submission:	19822495
*	Date:		2017-08-08 18:44:40
*	Runtime:	0.050
*	Ranking:	168
*/
public class Main13185 {

	/*
	 * - Perfectos
	 * 
	 * Encontrar si un número es perfecto, abundate o deficiente
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		int n = -1, cont;
		StringBuffer buf = new StringBuffer();
		while (testCases-- > 0) {
			cont = 1;
			n = Integer.parseInt(br.readLine());
			
			Set<Integer> divisors = new HashSet<Integer>();
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					divisors.add(i);
					divisors.add(n/i);
				}
			}
			
			for (Integer divisor : divisors) {
					cont += divisor;
			}


			if (n == 1) {
				buf.append("deficient\n");
			} else if (cont == n) {
				buf.append("perfect\n");
			} else if (cont > n) {
				buf.append("abundant\n");
			} else {
				buf.append("deficient\n");
			}
		}
		System.out.print(buf);
	}

}
